package kdruc.lesson12;

public class MyImplementation implements Repeatable{

  @Override
  public void doWork(int i) {
   for(int j=0 ; j <= i ; j++){
     System.out.println(j);
   }
  }

  @Override
  public int add(int a, int b) {
    return a+b;
  }
}
