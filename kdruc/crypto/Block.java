package kdruc.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Random;

public class Block {
  private static final Random randomGen = new Random();

  final private Transaction transaction;
  final private Calendar rightNow = Calendar.getInstance();
  final private String prevHash;

  private int nonce = Block.randomGen.nextInt();

  public Block(Transaction transaction, String prevHash) {
    this.transaction = new Transaction(transaction);
    this.prevHash = prevHash;
  }

  @Override
  public String toString() {
    return String.format("transaction: %s time: %s prevHash: %s nonce: %s", transaction, rightNow.getTime(), prevHash, nonce);
  }

  public String getHash() throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("MD5");
    byte[] encodedhash = digest.digest(
      this.toString().getBytes(StandardCharsets.UTF_8));
    return Utils.bytesToHex(encodedhash);
  }

  public boolean mine(int nonce) throws NoSuchAlgorithmException {
    this.nonce = nonce;
    String hash = this.getHash();
    int numOf0 = 0;

    int requiredLength = 4;

    for (int i = 0; i < requiredLength; i++) {
      if (hash.charAt(i) == '0') {
        numOf0++;
      }
    }

    return numOf0 == requiredLength;
  }
}