package uoft.csc207.fishtank;

import android.graphics.Canvas;

abstract class FishTankItem {

    abstract void setLocation(int x, int y);

    abstract void draw(Canvas canvas);

    abstract void move();
}
