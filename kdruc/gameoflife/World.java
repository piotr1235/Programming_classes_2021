package kdruc.gameoflife;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class World implements IWorld {
  // dimensions of the world
  private int n = 5, m = 7;

  // living and dead cells with border around
  private List<Boolean> cells = new ArrayList<>(Collections.nCopies((n + 2) * (m + 2), false));

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

  private int getX(int id) {
    return id % (n + 2);
  }

  private int getY(int id) {
    return id / (n + 2);
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
  public String drawWorld() throws OutOfBounds {

    String map = "";
    for (int j = 1; j <= m; j++) {
      for (int i = 1; i <= n; i++) {
        if (this.get(i, j)) {
          map += "#";

        } else {
          map += "_";
        }
      }
      map += "\n";
    }
    return map;
  }

  @Override
  public void tick() throws OutOfBounds {

    List<Integer> lives = new LinkedList<>();
    List<Integer> dies = new LinkedList<>();
    for (int j = 1; j <= m; j++) {
      for (int i = 1; i <= n; i++) {
        if (countNeighbours(i, j) < 2) {
          dies.add(getId(i, j));
        } else if (countNeighbours(i, j) == 3) {
          lives.add(getId(i, j));
        } else if (countNeighbours(i, j) > 3) {
          dies.add(getId(i, j));
        }
      }
    }

    for (int id : lives) {
      create(getX(id), getY(id));
    }

    for (int id : dies) {
      kill(getX(id), getY(id));
    }
  }

  @Override
  public void simulate(int t) {
    for (int i = 1; i <= t; i++) {
      try {
        System.out.print("\033[H\033[2J");
        System.out.println(drawWorld());
        tick();
        Thread.sleep(100);
      } catch (Exception ignored) { // OutOfBounds is included in Exception
      }
    }
  }

  @Override
  public void add(WorldObject worldObject) {
    for (int y = 0; y < worldObject.height; y++) {
      for (int x = 0; x < worldObject.width; x++) {
        if (worldObject.get(x, y)) {
          try {
            create(worldObject.x + x, worldObject.y + y);
          } catch (Exception ignored) {
          }
        }
      }
    }
  }

  public static void main(String[] args) throws OutOfBounds {
    IWorld world = new World();

    Spinner s1 = new Spinner(2, 2);
    world.add(s1);

    world.simulate(20);
  }
}
