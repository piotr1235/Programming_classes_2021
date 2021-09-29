package kdruc.lesson6;

public class References {

  public static void print(int[] a, String name) {
    System.out.printf("%s:[", name);
    for (int i : a) {
      System.out.printf("%d, ", i);
    }
    System.out.printf("]%n");
  }


  public static void main(String[] args) {
    int a = 10;
    int b = a;
    b = 20;
    System.out.printf("a:%d b:%d%n", a, b);

    int[] ax = new int[]{1, 2, 3, 4};
    int[] bx = new int[]{8, 7, 6, 5};
    System.out.printf("%s %s%n", ax.toString(), bx.toString()); // [I@4fca772d [I@9807454 - they are different

    bx = ax; // we modified one reference

    System.out.printf("%s %s%n", ax.toString(), bx.toString());

    bx[0] = 20; // we modified both of the arrays

    print(ax, "ax");
    print(bx, "bx");
  }
}
