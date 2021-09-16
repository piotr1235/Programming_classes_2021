package kdruc.lesson5;

import java.util.*;

public class ListDemo {
  public static void main(String[] args) {

    int tab[] = new int[]{1, 2, 3, 4};

    for (int i : tab) {
      System.out.println(i);
    }

    System.out.println("--------------------------------");

    List<Integer> list = new ArrayList<>();

    list.add(1);
    list.add(2);
    list.add(666);
    list.add(66666666);

    list.remove(1);

    int a = list.get(100000);

    System.out.printf("Element at the 2nd index (3rd element): %d %n", a);

    for (int i : list) {
      System.out.println(i);
    }

  }
}
