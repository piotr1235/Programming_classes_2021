package kdruc.crypto;


import java.util.Calendar;
import java.util.Random;

public class Block {
  private static final Random randomGen = new Random();

  final private Transaction transaction;
  final private Calendar rightNow = Calendar.getInstance();
  final private String prevHash;

  final private int nonce = Block.randomGen.nextInt();

  public Block(Transaction transaction, String prevHash) {
    this.transaction = new Transaction(transaction);
    this.prevHash = prevHash;
  }

  public String getHash() {
    return "";
  }

}
