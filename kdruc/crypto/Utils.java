package kdruc.crypto;

import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;

public abstract class Utils {
  public static String getShortKey(PublicKey key) {
    RSAPublicKey rsaKey = (RSAPublicKey) key;
    return rsaKey.getModulus().toString().substring(0, 10);
  }

  public static String bytesToHex(byte[] hash) {
    StringBuilder hexString = new StringBuilder(2 * hash.length);
    for (int i = 0; i < hash.length; i++) {
      String hex = Integer.toHexString(0xff & hash[i]);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      hexString.append(hex);
    }
    return hexString.toString();
  }
}
