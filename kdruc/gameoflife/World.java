package kdruc.gameoflife;

import kdruc.gameoflife.worldobjects.Multiple;
import kdruc.gameoflife.worldobjects.Spinner;
import kdruc.gameoflife.worldobjects.Square;
import kdruc.gameoflife.worldobjects.WorldObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class World extends WorldObject implements IWorld {

  // dimensions of the world
  //private int width, height;

  // living and dead cells with border around
  //private List<Boolean> cells;

  public World() {
    this(10, 10);
  }

  public World(int width, int height) {
    super(0, 0);
    this.width = width;
    this.height = height;

    this.cells = new ArrayList<>(Collections.nCopies((this.width + 2) * (this.height + 2), false));
  }

  public boolean editable(int x, int y) {
    return x >= 1 && x <= width && y >= 1 && y <= height;
  }

  private void check(int x, int y) throws OutOfBounds {
    if (x < 0 || y < 0 || x > width + 1 || y > height + 1) throw new OutOfBounds();
  }

  private int getId(int x, int y) throws OutOfBounds {
    check(x, y);
    return x + y * (width + 2);
  }

  private int getX(int id) {
    return id % (width + 2);
  }

  private int getY(int id) {
    return id / (width + 2);
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
    for (int j = 1; j <= height; j++) {
      for (int i = 1; i <= width; i++) {
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
    for (int j = 1; j <= height; j++) {
      for (int i = 1; i <= width; i++) {
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


  public static void main(String[] args) throws OutOfBounds {
    IWorld world = new World();

    WorldObject s1 = new Spinner(2, 2);
    WorldObject s2 = new Square(5, 5);

    //world.add(s1, s2);

    /*
    --##
    --##
    ##--
    ##--
     */

    WorldObject s3 = new Multiple(1, 1, new Square(3, 1), new Square(1, 3));
    world.add(s3);

    world.simulate(20);
  }
}
