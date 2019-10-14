package uoft.csc207.fishtank;

import android.graphics.Canvas;

import java.util.ArrayList;

class FishTankManager {

  /** All the locations where a fish can be. */
  private ArrayList<FishTankItem> myLittleFishies;
  /** The width of myLittleFishes. */
  private int gridWidth;
  /** The height of myLittleFishes. */
  private int gridHeight;

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
      FishTankItem current = myLittleFishies.get(i);
      if (current != null) {
        checkBounds(current, i); // check if out of bound and adjust accordingly
        int[] coords = current.move(); // let item move
        // add Bubble item if return array is not empty
        if (coords.length != 0) myLittleFishies.add(new Bubble(coords[0], coords[1]));
        // check for edible seaweed if item is a snail
        if (current instanceof HungryFish) lookForSnail(current, i);
      }
    }
  }

  /**
   * Helper method for checking if a snail is at the location of a hungry fish
   *
   * @param item the FishTankItem to be checked
   * @param i the index of the item in myLittleFishies
   */
  private void lookForSnail(FishTankItem item, int i) {
    for (int j = 0; j < myLittleFishies.size() && j != i; j++) {
      FishTankItem comparedItem = myLittleFishies.get(j);
      int x1 = item.getX();
      int y1 = item.getY();
      int x2 = comparedItem.getX();
      int y2 = comparedItem.getY();
      if ((comparedItem instanceof Snail) && x1 == x2 && y1 == y2) {
        myLittleFishies.remove(j);
      }
    }
  }

  /**
   * Helper method for checking if a FishTankItem is out of bound and adjust accordingly
   *
   * @param item the FishTankItem to be checked
   * @param i the index of the item in myLittleFishies
   */
  private void checkBounds(FishTankItem item, int i) {
    int x = item.getX();
    int y = item.getY();
    if (item instanceof Turnable) {
      // if item can turn around, it will be manually adjusted back in bound
      if (x <= 0) {
        item.setLocation(x + 1, y);
        ((Turnable) item).turnAround();
      } else if (x >= gridWidth - 1) {
        item.setLocation(x - 1, y);
        ((Turnable) item).turnAround();
      }
      if (y <= 0) item.setLocation(x, y + 1);
      else if (y >= gridHeight) item.setLocation(x, y - 1);
    } else {
      // if item cannot turn around, it will be removed once out of bound
      if (x <= 0 || x > gridWidth || y <= 0) myLittleFishies.remove(i);
    }
  }

  /** Initialize items in the fish tank*/
  void createTankItems() {
    myLittleFishies.add(new Fish(28, 18));
    myLittleFishies.add(new Fish(10, 22));
    myLittleFishies.add(new Fish(17, 14));
    myLittleFishies.add(new Fish(15, 28));
    myLittleFishies.add(new Fish(43, 18));
    myLittleFishies.add(new Fish(16, 36));
    myLittleFishies.add(new Snail(16, 40));
    myLittleFishies.add(new Snail(16, 32));
    myLittleFishies.add(new Snail(23, 34));
    myLittleFishies.add(new Snail(6, 35));
    myLittleFishies.add(new HungryFish(10, 20));
    myLittleFishies.add(new HungryFish(20, 10));
    myLittleFishies.add(new Seaweed(4, 33, 9));
    myLittleFishies.add(new Seaweed(13, 24, 6));
    myLittleFishies.add(new Seaweed(15, 42, 12));
    myLittleFishies.add(new Seaweed(20, 13, 5));
  }
}
