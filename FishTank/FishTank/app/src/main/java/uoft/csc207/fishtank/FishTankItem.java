package uoft.csc207.fishtank;

import android.graphics.Canvas;

public abstract class FishTankItem {

    /** This bubble's first coordinate. */
    int x;
    /** This bubble's second coordinate. */
    int y;

    abstract void setLocation(int x, int y);

    abstract void draw(Canvas canvas);

    abstract void move();
}