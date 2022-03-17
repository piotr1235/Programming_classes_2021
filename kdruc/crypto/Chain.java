package kdruc.crypto;

import java.security.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Chain {

  static private Chain instance;

  private Wallet genesis = new Wallet();
  private Wallet master = new Wallet();


  private List<Block> blockList;

  private Chain() throws NoSuchAlgorithmException {
    Transaction transaction = new Transaction(genesis.getKey(), master.getKey(), 1000);
    Block block = new Block(transaction, "0000000000000000000000000000000");
    blockList = new Stack<>();
    blockList.add(block);
  }

  static public Chain getInstance() throws NoSuchAlgorithmException {
    if (instance == null) {
      instance = new Chain();
    }
    return instance;
  }

  private Block getLastBlock() {
    return blockList.get(0);
  }

  public boolean addBlock(Transaction transaction, byte[] digitalSignature, PublicKey publicKey, int nonce) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    Signature signature = Signature.getInstance("SHA256withRSA");
    signature.initVerify(publicKey);
    byte[] messageBytes = transaction.toString().getBytes();
    signature.update(messageBytes);
    boolean isCorrect = signature.verify(digitalSignature);
    if (!isCorrect) return false;
    Block block = new Block(transaction, getLastBlock().getHash());
    boolean mined = block.mine(nonce);
    if (mined) {
      blockList.add(block);
      return true;
    }
    return false;
  }
}
