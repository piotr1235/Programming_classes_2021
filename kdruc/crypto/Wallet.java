package kdruc.crypto;

import java.security.*;

public class Wallet {
  private PublicKey publicKey = null; // your identity
  private PrivateKey privateKey = null; // your password

  KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");

  public Wallet() throws NoSuchAlgorithmException {
    generateKeys();
  }

  private void generateKeys() {
    keyGen.initialize(2048);
    KeyPair keyPair = keyGen.generateKeyPair();
    publicKey = keyPair.getPublic();
    privateKey = keyPair.getPrivate();
  }

  public PublicKey getKey() {
    return publicKey;
  }

  public boolean sendMoney(int amount, PublicKey sendTo, int nonce) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    Transaction transaction = new Transaction(this.publicKey, sendTo, amount);
    Signature signature = Signature.getInstance("SHA256withRSA");
    signature.initSign(privateKey);

    byte[] messageBytes = transaction.toString().getBytes();

    signature.update(messageBytes);
    byte[] digitalSignature = signature.sign();

    Chain chain = Chain.getInstance();
    return chain.addBlock(transaction, digitalSignature, publicKey, nonce);
  }

  public void sendMoneyMine(int amount, PublicKey sendTo) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    for (int i = 0; i < 1000000; i++) {
      if (sendMoney(amount, sendTo, i)) break;
    }
  }

  public int getMyBalance() throws NoSuchAlgorithmException {
    int myBalance = 0;
    for (Block block :
      Chain.getInstance().getBlocks()) {
      Transaction transaction = block.getTransaction();
      if (transaction.getAccountFrom() == publicKey) {
        myBalance -= transaction.getAmount();
      }
      if (transaction.getAccountTo() == publicKey) {
        myBalance += transaction.getAmount();
      }
    }
    return myBalance;
  }

}
