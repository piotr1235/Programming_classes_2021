package kdruc.crypto;

import java.security.*;
import java.util.List;
import java.util.Stack;

public class Chain {

  static private Chain instance;

  private Wallet genesis = new Wallet();
  private Wallet master = new Wallet();


  private Stack<Block> blockList;

  private Chain() throws NoSuchAlgorithmException {
    Transaction transaction = new Transaction(genesis.getKey(), master.getKey(), 1000);
    Block block = new Block(transaction, "00000000000000000000000000000000");
    for (int i = 0; i < 1000000; i++) {
      if (block.mine(i)) break;
    }
    blockList = new Stack<>();
    blockList.push(block);
  }

  static public Chain getInstance() throws NoSuchAlgorithmException {
    if (instance == null) {
      instance = new Chain();
    }
    return instance;
  }

  private Block getLastBlock() {
    return blockList.peek();
  }

  public boolean addBlock(ITransaction transaction, byte[] digitalSignature, PublicKey publicKey, int nonce) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    Signature signature = Signature.getInstance("SHA256withRSA");
    signature.initVerify(publicKey);
    byte[] messageBytes = transaction.toString().getBytes();
    signature.update(messageBytes);
    boolean isCorrect = signature.verify(digitalSignature);
    if (!isCorrect) return false;
    Block block = new Block(transaction, getLastBlock().getHash());
    boolean mined = block.mine(nonce);
    if (mined) {
      blockList.push(block);
      return true;
    }
    return false;
  }

  public Wallet getMasterPK() {

    return master;
  }

  public String toString() {
    StringBuilder allBlocks = new StringBuilder();
    for (Block block : blockList) {
      allBlocks.append(block.toString()).append("\n");
    }
    return allBlocks.toString();
  }

  public List<Block> getBlocks() {
    return blockList;
  }

}
