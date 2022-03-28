package kdruc.crypto;

import java.security.*;
import java.util.LinkedList;
import java.util.List;

public class Wallet {
  private PublicKey publicKey = null; // your identity
  private PrivateKey privateKey = null; // your password
  private List<UTXO> myCoins;

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
    int balance = 0;
    String myPublicKeyHash;
    for ( UTXO coin:
         this.myCoins) {
      for (TransactionOutput output:
      coin.getOutputList()) {
        if(output.getPublicKeyHash() == myPublicKeyHash){
          balance+= output.getValue();
        }

      }
    }
    return balance;
  }
  public void addCoin(UTXO utxo){
    if(this.myCoins == null) this.myCoins = new LinkedList<>();
    this.myCoins.add(utxo);
  }

}
