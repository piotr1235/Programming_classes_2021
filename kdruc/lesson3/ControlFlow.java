package kdruc.lesson3;

public class ControlFlow {
  public static void main(String[] args) {
    int j = 1;
    for (; j <= 10; ) {
      System.out.println(j);
      j++;
    }

    int i = 1;
    while (i < 10) {
      System.out.println(i + i);
      i++;
    }
  }
}
