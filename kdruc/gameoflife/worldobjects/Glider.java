package kdruc.gameoflife.worldobjects;

import kdruc.gameoflife.OutOfBounds;

import java.util.ArrayList;
import java.util.Collections;

public class Glider extends WorldObject {
  public Glider(int x, int y) {
    super(x, y);
    this.height = 3;
    this.width = 3;
    this.cells = new ArrayList<>(Collections.nCopies((height) * (width), false));
    try {
      this.add(new Spinner(2, 0));
    } catch (OutOfBounds o) {
    }
    this.cells.set(3, true);
    this.cells.set(7, true);
  }
}