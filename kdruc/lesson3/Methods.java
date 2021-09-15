package kdruc.lesson3;

public class Methods {

  public static void printNumbersInRange(int a) { // method, inner function
    if (a == 0) return;

    System.out.println(a);
    printNumbersInRange(a - 1);
  }

  public static int factorial(int a) {
    int b = 1;
    for (int i = a; i > 0; i--) {
      b = i * b;
    }
    System.out.println(b); // printing
    return b; // returning
  }

  public static int factorialRec(int n) { // be aware of stack overflow
    if (n == 0) return 1;
    return n * factorialRec(n - 1);
  }

  public static void main(String[] args) {
    //printNumbersInRange(5);

    int n = factorial(20); // 5! = 5*4*3*2*1;
    //System.out.println(n);
  }
}

/*
// recursive -> causes problem with stack overflow
                      ...     _0_
                _2_   ...
          _3_   _3_   ...
     _4_  _4_   _4_   ...
_5_  _5_  _5_   _5_   ...


// tail recursive
_5_  -> _4_  -> _3_ -> _2_ -> ... -> _0_
 */
