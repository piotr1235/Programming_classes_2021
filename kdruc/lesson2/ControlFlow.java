package kdruc.lesson2;

import java.util.Scanner;

public class ControlFlow {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int b = 10; // initialisation

    int a; // declaration
    a = in.nextInt(); // assignment

    if (a % 2 == 0) {
      System.out.println("even");
    } else {
      System.out.println("odd");
    }
  }
}

// formatting -> ctrl + alt + l
