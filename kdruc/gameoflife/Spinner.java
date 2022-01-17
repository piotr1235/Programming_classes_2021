package kdruc.gameoflife;

import java.util.ArrayList;
import java.util.Collections;

public class Spinner extends WorldObject {

  public Spinner() {
    this(1, 1); // runs different constructor from the same class
  }

  public Spinner(int x, int y) {
    super(x, y); // constructor from super/parent class
    this.height = 3;
    this.width = 1;
    this.cells = new ArrayList<>(Collections.nCopies((height) * (width), true));
  }
}
