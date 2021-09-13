package kdruc.lesson2;

public class Primitives {
  public static void main(String[] args) {
    int a = 9 * 8;
    int b = 10; // -2^32  :  2^32 - 1
    char c = 'k'; // -2^16  :  2^16 - 1
    boolean d = true; // 0  :  1
    float e = 1f; // floating point
    double f = 3.56; // double precision
    double g = 3e10; // 3e10 = 3 * 10^10
    byte h = 10; // -128  :  127
    char i = 97; // code ASCII values 97 = 'a'
    int j = 'A'; // 65 = 'A'
    long k = 2147483648L; // -2^64  :  2^64 - 1  long in java is the same as long long in C++

    // byte, char, int, long -> 8, 16, 32, 64 bits
    // float, double -> 32, 64 bits
    // boolean -> 1 bit
    // 1 byte = 8 bits,  e.g. 100MB = 800Mb    2^3 = 8

    // what if we want to represent bigger numbers?
    //    BigInteger big = new BigInteger("10000000000000000", 1);
    //    BigInteger bigbig = big.multiply(big);
    //    System.out.println(bigbig);

    System.out.println(Integer.MIN_VALUE); // System.out.println() -> sout
    System.out.println(Integer.MAX_VALUE);
    System.out.println(c);
    System.out.println(e);
    System.out.println(f);
    System.out.println(g);
    System.out.println(h);
    System.out.println(i);
    System.out.println(j);
  }
}
