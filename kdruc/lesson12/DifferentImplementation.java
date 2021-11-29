package kdruc.lesson12;

public class DifferentImplementation implements Repeatable{
  @Override
  public void doWork(int i) {
    int j = 0;
    while(j<=i){
      System.out.println(j);
      j++;
    }
  }

  @Override
  public int add(int a, int b) {
    int sum=0;
    for(int i=0 ; i<a ; i++) sum++;
    for(int i=0 ; i<b ; i++) sum++;

    return sum;
  }
}
