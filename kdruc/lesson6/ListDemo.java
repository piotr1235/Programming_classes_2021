package kdruc.lesson6;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

  public static void a(List<List<Integer>> list) {
    ArrayList first = new ArrayList(list.get(0)); // references because complex type
    first.add(0, 10);
  }

  public static void b(List<Integer> list) {
    int first = list.get(0); // no references because primitive type
    first = 10;
  }

  public static void print(List<int[]> list) {
    for (int[] i : list) {
      System.out.printf("[");
      for (int j : i) {
        System.out.printf("%s", j);
      }
      System.out.printf("]");
    }
    System.out.println();
  }


  public static void main(String[] args) {
    List list = new ArrayList<int[]>(List.of(new int[]{1}, new int[]{2}, new int[]{3}, new int[]{4}));
    print(list);
    a(list);
    print(list);

    List list2 = new ArrayList<Integer>(List.of(1, 2, 3, 4));
    System.out.println(list2); // [1,2,3,4]
    b(list2);
    System.out.println(list2);
  }
}
