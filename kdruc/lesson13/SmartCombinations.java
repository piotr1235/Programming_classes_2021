package kdruc.lesson13;

import java.util.LinkedList;
import java.util.List;

public class SmartCombinations implements IAllCombinations {
  @Override
  public int getSize(int n) {
    return 0;
  }

  @Override
  public List<String> getAllCombinations(int n) {
    List<String> result = new LinkedList<String>();

    int Max = (int) Math.pow(10, n);

    String s = "%0" + n + "d";

    for (int i = 0; i < Max; i++) {
      String pin = String.format(s, i);
      result.add(pin);
    }
    return result;
  }

  public static void main(String[] args) {
    SmartCombinations t = new SmartCombinations();
    List<String> allCombinations = t.getAllCombinations(3);
    System.out.println(allCombinations);
  }
}
