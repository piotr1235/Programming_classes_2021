package kdruc.lesson12;

public class TestImplementations {
  public static void main(String[] args) {
    MyImplementation imp1 = new MyImplementation();
    DifferentImplementation imp2 = new DifferentImplementation();

    imp1.doWork(5);
    int sum1 = imp1.add(4,5);
    System.out.println();
    System.out.println(sum1);
    System.out.println();
    imp2.doWork(5);
    int sum2 = imp2.add(3,2);
    System.out.println();
    System.out.println(sum2);
  }
}
