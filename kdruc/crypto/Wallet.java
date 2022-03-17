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

  public void sendMoney(int amount, PublicKey sendTo){
    
  }
}
