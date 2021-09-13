package kdruc.lesson2;

public class ComplexTypes {
  public static void main(String[] args) {
    // primitive - just value
    // class/complex type - value/multiple value/methods

    String s = "Hello";

    String ss = s.toUpperCase();
    System.out.println(s);
    System.out.println(ss);

    Integer a = 10;
    // float b = (float) a.doubleValue();
    double b = a.doubleValue();
  }
}
