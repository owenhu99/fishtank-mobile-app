package uoft.csc207.fishtank;

import android.graphics.Canvas;

public class FishTankManager {

  /** All the locations where a fish can be. */
  protected static FishTankItem[][] myLittleFishies;
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
  public FishTankManager(int height, int width) {
    gridHeight = height;
    gridWidth = width;
    myLittleFishies = new FishTankItem[height][width];
  }

  public void draw(Canvas canvas) {
    for (int a = 0; a != gridHeight; a++) {
      for (int b = 0; b != gridWidth; b++) {
        if (FishTankManager.myLittleFishies[a][b] != null)
          FishTankManager.myLittleFishies[a][b].draw(canvas);
        }
      }
    }

  public void update() {
    for (int a = 0; a != gridHeight; a++) {
      for (int b = 0; b != gridWidth; b++) {
        if (FishTankManager.myLittleFishies[a][b] != null)
          FishTankManager.myLittleFishies[a][b].move();
      }
    }
  }

  public void createTankItems() {
    FishTankManager.myLittleFishies[28][18] = new Fish(28, 18);
    FishTankManager.myLittleFishies[10][22] = new Fish(10, 22);
    myLittleFishies[17][14] = new Fish(17, 14);
    myLittleFishies[15][28] = new Fish(15, 28);
    myLittleFishies[43][18] = new Fish(43, 18);
    myLittleFishies[16][5] = new Fish(16, 5);
    myLittleFishies[16][12] = new Fish(16, 12);
    myLittleFishies[16][22] = new Fish(16, 22);
    myLittleFishies[23][18] = new Fish(23, 18);
    myLittleFishies[6][12] = new Fish(6, 12);
    myLittleFishies[10][20] = new HungryFish(10, 20);
    myLittleFishies[33][4] = new Seaweed(33,4, 9);
    myLittleFishies[24][13] = new Seaweed(24, 13, 6);
    myLittleFishies[42][15] = new Seaweed(42, 15, 12);
    myLittleFishies[13][20] = new Seaweed(13, 20, 5);
  }
}
