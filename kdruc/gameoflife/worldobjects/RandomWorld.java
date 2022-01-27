package kdruc.gameoflife.worldobjects;

import kdruc.gameoflife.OutOfBounds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomWorld extends WorldObject {
  Random gen = new Random();

  public RandomWorld(int x, int y) {
    super(x, y);
    this.width = 10;
    this.height = 10;

    this.cells = new ArrayList<>(Collections.nCopies((height) * (width), false));
    for (int i = 0; i < width * height; i++) {
      if (gen.nextBoolean()) {
        this.cells.set(i, true);
      }
    }
  }
}
