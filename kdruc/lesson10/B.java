package kdruc.lesson10;

public class B {
  public static void main(String[] args) {
    A a = new A();
    // System.out.println(a.password); - illegal
    System.out.println(a.getPassword()); // getter

    // set
    // a.password = "123"; - illegal
    a.setPassword("432"); // setter
  }
}
