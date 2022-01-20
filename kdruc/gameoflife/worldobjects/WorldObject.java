package kdruc.gameoflife.worldobjects;

import kdruc.gameoflife.OutOfBounds;

import java.util.List;

public abstract class WorldObject {
  public List<Boolean> cells;
  public int height = 0;
  public int width = 0;
  public int x;
  public int y;

  public WorldObject(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean get(int x, int y) throws OutOfBounds {
    return cells.get(x + y * width);
  }

  public void add(WorldObject... worldObjects) throws OutOfBounds {

    for (WorldObject worldObject : worldObjects) {
      for (int y = 0; y < worldObject.height; y++) {
        for (int x = 0; x < worldObject.width; x++) {
          if (worldObject.get(x, y)) {
            try {
              cells.set(worldObject.x + x - 1 + (worldObject.y + y - 1) * this.width, true);
            } catch (Exception ignored) {
            }
          }
        }
      }
    }
  }
}
