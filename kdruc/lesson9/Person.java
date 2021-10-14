package kdruc.lesson9;

public class Person {

  public static int idCount;

  public String name;
  public int id;
  public int age;

  public void printInfo() {
    System.out.printf("%8s %-4s%n", name, id);
  }

  public void sing() {
    System.out.println("aaaaaaaaaaaaaaa");
  }
}
