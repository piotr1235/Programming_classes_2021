package kdruc.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class Blockchain {

  public static void main(String[] args) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
    Wallet s1 = new Wallet();
    Wallet s2 = new Wallet();
    Wallet s3 = new Wallet();
    Wallet master = Chain.getInstance().getMasterPK();
    master.sendMoneyMine(10, s1.getKey());
    master.sendMoneyMine(500, s2.getKey());
    master.sendMoneyMine(1, s3.getKey());
    s2.sendMoneyMine(100, s1.getKey());
    s1.sendMoneyMine(1, s3.getKey());
    System.out.println(Chain.getInstance());
    System.out.println(master.getMyBalance());
    System.out.println(s1.getMyBalance());
    System.out.println(s2.getMyBalance());
    System.out.println(s3.getMyBalance());
  }
}
