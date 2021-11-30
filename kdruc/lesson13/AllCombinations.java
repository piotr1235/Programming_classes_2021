package kdruc.lesson13;

import java.util.LinkedList;
import java.util.List;

public class AllCombinations implements IAllCombinations {

  @Override
  public int getSize(int n) {
    String s = String.valueOf(n);
    return s.length();
  }

  @Override
  public List<String> getAllCombinations(int n) {
    List<String> result = new LinkedList<>();

    int Max = (int) Math.pow(10, n);
    String test = "";
    for (int i = 0; i < Max; i++) {
      int numOfZeros = n - getSize(i);
      test = "";
      for (int j = 0; j < numOfZeros; j++) test += "0";
      result.add(test + i);
    }
    return result;
  }

  public static void main(String[] args) {
    AllCombinations t = new AllCombinations();
    List<String> allCombinations = t.getAllCombinations(4);
    System.out.println(allCombinations);
  }
}
