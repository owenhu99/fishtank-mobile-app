package uoft.csc207.fishtank;

import android.graphics.Canvas;

public class FishTankManager {

    /**
     * All the locations where a fish can be.
     */
    public static Object[][] myLittleFishies;
    /**
     * The width of myLittleFishes.
     */
    private int gridWidth;
    /**
     * The height of myLittleFishes.
     */
    private int gridHeight;


    /**
     * Return the width of a row of locations.
     * @return the width of a column of locations.
     */
    public int getGridWidth() {
        return gridWidth;
    }

    /**
     * Return the height of a column of locations.
     * @return the height of a column of locations.
     *
     */
    public int getGridHeight() {
        return gridHeight;
    }

    /**
     * The fish tank manager on a screen with height rows and width columns.
     */
    public FishTankManager(int height, int width) {
        gridHeight = height;
        gridWidth = width;
        myLittleFishies = new Object[height][width];
    }

    public void draw(Canvas canvas) {
        for (int a = 0; a != gridHeight; a++) {
            for (int b = 0; b != gridWidth; b++) {
                if (FishTankManager.myLittleFishies[a][b] != null)
                    if (FishTankManager.myLittleFishies[a][b] instanceof Fish) {
                        ((Fish) FishTankManager.myLittleFishies[a][b]).draw(canvas);
                    } else if (FishTankManager.myLittleFishies[a][b] instanceof Seaweed) {
                        ((Seaweed) FishTankManager.myLittleFishies[a][b]).draw(canvas);
                    } else if (FishTankManager.myLittleFishies[a][b] instanceof HungryFish) {
                        ((HungryFish) FishTankManager.myLittleFishies[a][b]).draw(canvas);
                    }
                if (FishTankManager.myLittleFishies[a][b] instanceof Bubble) {
                    Bubble heybub = (Bubble) FishTankManager.myLittleFishies[a][b];
                    heybub.draw(canvas);
                }
            }
        }
    }

    public void update() {
        for (int a = 0; a != gridHeight; a++) {
            for (int b = 0; b != gridWidth; b++) {
                if (FishTankManager.myLittleFishies[a][b] != null)
                    if (FishTankManager.myLittleFishies[a][b] instanceof Fish) {
                        ((Fish) FishTankManager.myLittleFishies[a][b]).move();
                    } else if (FishTankManager.myLittleFishies[a][b] instanceof Seaweed) {
                        ((Seaweed) FishTankManager.myLittleFishies[a][b]).wave();
                    } else if (FishTankManager.myLittleFishies[a][b] instanceof HungryFish) {
                        ((HungryFish) FishTankManager.myLittleFishies[a][b]).move();
                    }
                if (FishTankManager.myLittleFishies[a][b] instanceof Bubble) {
                    // Figure out whether to float left or right, if at all.
                    Bubble heybub = (Bubble) FishTankManager.myLittleFishies[a][b];
                    heybub.d = Math.random();
                    if (heybub.d < 0.33) heybub.floatStraightUp();
                    else if (heybub.d < 0.66) heybub.floatRightUp();
                    else /* heybub.d >= 0.66 */ heybub.floatLeftUp();
                }
            }
        }
    }

    public void createTankItems() {
        FishTankManager.myLittleFishies[28][18] = new Fish();
        ((Fish) FishTankManager.myLittleFishies[28][18]).setLocation(28, 18);
        FishTankManager.myLittleFishies[10][22] = new Fish();
        ((Fish) FishTankManager.myLittleFishies[10][22]).setLocation(10, 22);
        myLittleFishies[17][14] = new Fish();
        ((Fish) myLittleFishies[17][14]).setLocation(17, 14);
        myLittleFishies[15][28] = new Fish();
        ((Fish) myLittleFishies[15][28]).setLocation(15, 28);
        myLittleFishies[43][18] = new Fish();
        ((Fish) myLittleFishies[43][18]).setLocation(35, 36);
        myLittleFishies[16][5] = new Fish();
        ((Fish) myLittleFishies[16][5]).setLocation(16, 5);
        myLittleFishies[16][12] = new Fish();
        ((Fish) myLittleFishies[16][12]).setLocation(16, 12);
        myLittleFishies[16][22] = new Fish();
        ((Fish) myLittleFishies[16][22]).setLocation(16, 18);
        myLittleFishies[23][18] = new Fish();
        ((Fish) myLittleFishies[23][18]).setLocation(23, 18);
        myLittleFishies[6][12] = new Fish();
        ((Fish) myLittleFishies[6][12]).setLocation(6, 12);
        myLittleFishies[10][20] = new HungryFish();
        ((HungryFish) myLittleFishies[10][20]).setLocation(10, 20);
        myLittleFishies[33][4] = new Seaweed(9);
        ((Seaweed) myLittleFishies[33][4]).setLocation(33, 4);
        myLittleFishies[24][13] = new Seaweed(6);
        ((Seaweed) myLittleFishies[24][13]).setLocation(24, 13);
        myLittleFishies[42][15] = new Seaweed(12);
        ((Seaweed) myLittleFishies[42][15]).setLocation(42, 15);
        myLittleFishies[13][20] = new Seaweed(5);
        ((Seaweed) myLittleFishies[13][20]).setLocation(13, 20);
    }
}
