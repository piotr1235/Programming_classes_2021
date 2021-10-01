package kdruc.lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListReferences {

  private static List<String> a(List<String> l) {
    List<String> r = new ArrayList<>(l); // copy
    r.set(0, r.get(1));
    return r;
  }

  private static void b(List<String> l) {
    l.set(0, l.get(0).toUpperCase());
  }

  public static void main(String[] args) {
    List<String> strings = Arrays.asList("Java", "is", "cool");
    List<String> next = a(strings);
    b(strings);
    System.out.printf("%s, %s%n", next, strings);
  }
}
