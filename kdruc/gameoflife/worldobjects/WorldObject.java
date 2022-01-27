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

  public boolean editable(int x, int y) {
    return x >= 1 && x <= width && y >= 1 && y <= height;
  }

  private void check(int x, int y) throws OutOfBounds {
    if (x < 0 || y < 0 || x > width + 1 || y > height + 1) throw new OutOfBounds();
  }

  protected int getId(int x, int y) throws OutOfBounds {
    check(x, y);
    return x + y * (width);
  }

  protected int getX(int id) {
    return id % (width);
  }

  protected int getY(int id) {
    return id / (width);
  }

  public void add(WorldObject... worldObjects) throws OutOfBounds {
    this.add(0, 0, worldObjects);
  }

  public void add(int xAdd, int yAdd, WorldObject... worldObjects) throws OutOfBounds {
    for (WorldObject worldObject : worldObjects) {
      for (int y = 0; y < worldObject.height; y++) {
        for (int x = 0; x < worldObject.width; x++) {
          if (worldObject.get(x, y)) {
            try {
              cells.set(worldObject.x + x + xAdd + (worldObject.y + y + yAdd) * this.width, true);
            } catch (Exception ignored) {
            }
          }
        }
      }
    }
  }
}
