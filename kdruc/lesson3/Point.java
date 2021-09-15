package kdruc.lesson3;

public class Point {

  String name = "";

  int x; // fields
  int y;

  public Point() {
    name = "point0";
    x = 1;
    y = 5;
  }

  public Point(int a) {
    name = "point1";
    y = a;
    x = a;
  }

  public Point(int b, int c) {
    name = "point2";
    x = b;
    y = c;
  }

  public Point(String s) {
    name = "point3";
    x = 100;
    y = 100;
  }

  void printMe() {
    System.out.println(x);
    System.out.println(y);
  }

  public static void main(String[] args) {
    Point p = new Point(); // object, constructor
    p.printMe();
    p.x = 10;
    p.y = 20;
    p.printMe();
    p.x = 30;
    p.printMe();

    Point q = new Point(637);
    q.printMe();

    Point r = new Point(6, 3);
    r.printMe();

    Point s = new Point("hello");
    s.printMe();

    p.name = "test";

    System.out.println(p.name);
    System.out.println(q.name);
    System.out.println(r.name);
    System.out.println(s.name);
  }
}
