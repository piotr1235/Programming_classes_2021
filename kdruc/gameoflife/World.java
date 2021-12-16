package kdruc.gameoflife;

import java.util.Collections;
import java.util.List;


public class World implements IWorld {
  // dimensions of the world
  private int n = 10, m = 10;

  // living and dead cells with border around
  private List<Boolean> cells = Collections.nCopies((n + 2) * (m + 2), false);

  public boolean editable(int x, int y) {
    return x >= 1 && x <= n && y >= 1 && y <= m;
  }

  private void check(int x, int y) throws OutOfBounds {
    if (x < 0 || y < 0 || x > n + 1 || y > m + 1) throw new OutOfBounds();
  }

  private int getId(int x, int y) throws OutOfBounds {
    check(x, y);
    return x + y * (n + 2);
  }

  @Override
  public int countNeighbours(int x, int y) throws OutOfBounds {
    int count = 0;
    for (int i = 1; i >= -1; i--) {
      for (int j = 1; j >= -1; j--) {
        if (i == 0 && j == 0) continue;
        if (get(x + i, y + j)) count++;
      }
    }
    return count;
  }

  @Override
  public boolean get(int x, int y) throws OutOfBounds {
    int id = getId(x, y);
    return cells.get(id);
  }

  @Override
  public void kill(int x, int y) throws OutOfBounds {
    if (editable(x, y)) {
      int id = getId(x, y);
      cells.set(id, false);
    }
  }

  @Override
  public void create(int x, int y) throws OutOfBounds {
    if (editable(x, y)) {
      int id = getId(x, y);
      cells.set(id, true);
    }
  }

  @Override
  public String drawWorld() {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {

      }
    }
    return null;
  }

  @Override
  public void tick() {

  }
}
