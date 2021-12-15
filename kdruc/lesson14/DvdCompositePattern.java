package kdruc.lesson14;

import kdruc.lesson10.B;

import java.util.Arrays;
import java.util.List;

interface Watchable {
  double price();

  String title();
}

class Dvd implements Watchable {
  private final int price;
  private final String title;

  public Dvd(int price, String title) {
    this.price = price;
    this.title = title;
  }

  @Override
  public double price() {
    return price;
  }

  @Override
  public String title() {
    return title;
  }

  @Override
  public String toString() {
    return String.format("%s: £%.2f", title(), price());
  }
}

class BlueRay implements Watchable {
  private final int price;
  private final String title;
  private final double qualityScore;

  public BlueRay(int price, String title) {
    this.price = price;
    this.title = "Blue Ray: " + title;
    this.qualityScore = 0.9;
  }

  @Override
  public double price() {
    return price;
  }

  @Override
  public String title() {
    return title;
  }

  @Override
  public String toString() {
    return String.format("%s: £%.2f", title(), price());
  }
}

class DvdBox implements Watchable {
  private final List<Watchable> dvdList;

  private double total;
  private String title;
  private final int discount = 4;

  public DvdBox(Watchable... dvdList) {
    this.dvdList = List.copyOf(Arrays.asList(dvdList));
    int n = this.dvdList.size();
    this.title = "Box(";
    for (int i = 0; i < n; i++) {
      this.total += this.dvdList.get(i).price();
      this.title += this.dvdList.get(i).title();
    }
    this.total *= (1 - (this.discount / 100.0));
    this.title += ")";
  }

  @Override
  public double price() {
    return total;
  }

  @Override
  public String title() {
    return title;
  }

  @Override
  public String toString() {
    return String.format("%s: £%.2f", title(), price());
  }
}

public class DvdCompositePattern {
  public static void main(String[] args) {
    Dvd s = new Dvd(100, "Matrix");

    Dvd m1 = new Dvd(100, "Episode IV: A New Hope");
    Dvd m2 = new Dvd(100, "Episode V: The Empire Strikes Back");
    BlueRay m3 = new BlueRay(100, "Episode VI: Return of the Jedi");

    DvdBox box = new DvdBox(m1, m2);
    DvdBox box2 = new DvdBox(box, m3);
    System.out.println(m1);
    System.out.println(box2);
  }
}


