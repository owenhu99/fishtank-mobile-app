package uoft.csc207.fishtank;

import android.graphics.Canvas;

import java.util.ArrayList;

public class FishTankManager {

  /** All the locations where a fish can be. */
  static ArrayList<FishTankItem> myLittleFishies;
  /** The width of myLittleFishes. */
  private int gridWidth;
  /** The height of myLittleFishes. */
  private int gridHeight;

  /**
   * Return the width of a row of locations.
   *
   * @return the width of a column of locations.
   */
  public int getGridWidth() {
    return gridWidth;
  }

  /**
   * Return the height of a column of locations.
   *
   * @return the height of a column of locations.
   */
  public int getGridHeight() {
    return gridHeight;
  }

  /** The fish tank manager on a screen with height rows and width columns. */
  FishTankManager(int height, int width) {
    gridHeight = height;
    gridWidth = width;
    myLittleFishies = new ArrayList<>();
  }

  void draw(Canvas canvas) {
    for (int i = 0; i < myLittleFishies.size(); i++) {
      if (myLittleFishies.get(i) != null) myLittleFishies.get(i).draw(canvas);
    }
  }

  void update() {
    for (int i = 0; i < myLittleFishies.size(); i++) {
      if (myLittleFishies.get(i) != null) myLittleFishies.get(i).move();
    }
  }

  void createTankItems() {
    myLittleFishies.add(new Fish(28, 18));
    myLittleFishies.add(new Fish(10, 22));
    myLittleFishies.add(new Fish(17, 14));
    myLittleFishies.add(new Fish(15, 28));
    myLittleFishies.add(new Fish(43, 18));
    myLittleFishies.add(new Fish(16, 5));
    myLittleFishies.add(new Fish(16, 12));
    myLittleFishies.add(new Fish(16, 22));
    myLittleFishies.add(new Fish(23, 18));
    myLittleFishies.add(new Fish(6, 12));
    myLittleFishies.add(new HungryFish(10, 20));
    myLittleFishies.add(new Seaweed(4,33, 9));
    myLittleFishies.add(new Seaweed(13, 24, 6));
    myLittleFishies.add(new Seaweed(15, 42, 12));
    myLittleFishies.add(new Seaweed(20, 13, 5));
  }
}
