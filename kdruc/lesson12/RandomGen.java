package kdruc.lesson12;

import java.util.Random;

public class RandomGen {

  public static void main(String[] args) {
    Random r = new Random();
    for(int i =0 ; i<10 ; i++) {
      int next = r.nextInt();
      System.out.printf("%d ", next%10);
    }
  }
}
