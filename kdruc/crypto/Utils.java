package kdruc.crypto;

import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;

public abstract class Utils {
  public static String getShortKey(PublicKey key) {
    RSAPublicKey rsaKey = (RSAPublicKey) key;
    return rsaKey.getModulus().toString().substring(0, 10);
  }
}
