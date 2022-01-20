package kdruc.gameoflife.worldobjects;

import java.util.ArrayList;
import java.util.Collections;

public class Square extends WorldObject {
  public Square(int x, int y) {
    super(x, y);
    this.height = 2;
    this.width = 2;
    this.cells = new ArrayList<>(Collections.nCopies((height) * (width), true));
  }
}
