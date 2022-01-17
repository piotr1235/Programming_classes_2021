package kdruc.gameoflife;

import java.util.List;

public abstract class WorldObject {
  public List<Boolean> cells;
  int height = 0;
  int width = 0;
  int x;
  int y;

  public WorldObject(int x, int y) {
    this.x = x;
    this.y = y;
  }

  boolean get(int x, int y) {
    return cells.get(x + y * width);
  }
}
