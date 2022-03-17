package kdruc.crypto;

import java.security.NoSuchAlgorithmException;

public class Blockchain {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    Chain c = Chain.getInstance();
    Chain c1 = Chain.getInstance();
    Chain c2 = Chain.getInstance();
    Chain c3 = Chain.getInstance();
    Chain c4 = Chain.getInstance();
    System.out.println(c);
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
  }
}
