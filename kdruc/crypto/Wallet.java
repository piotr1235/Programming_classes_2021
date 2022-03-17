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

  public void sendMoney(int amount, PublicKey sendTo) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    Transaction transaction = new Transaction(this.publicKey, sendTo, amount);
    Signature signature = Signature.getInstance("SHA256withRSA");
    signature.initSign(privateKey);

    byte[] messageBytes = transaction.toString().getBytes();

    signature.update(messageBytes);
    byte[] digitalSignature = signature.sign();

    Chain chain = Chain.getInstance();
    chain.addBlock(transaction, digitalSignature, publicKey, 0);
  }
}
