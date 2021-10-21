package kdruc.lesson10;

public class A {

  private String password = "hf920sjal";

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public static void main(String[] args) {
    A a = new A();
    // get
    System.out.println(a.password);
    System.out.println(a.getPassword());

    // set
    a.password = "123";
    a.setPassword("432");
  }
}
