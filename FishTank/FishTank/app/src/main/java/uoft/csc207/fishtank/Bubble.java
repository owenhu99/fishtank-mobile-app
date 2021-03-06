package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/** A bubble. */
public class Bubble extends FishTankItem {

  /** How this bubble appears on the screen. */
  private String appearance;

  /** This bubble's first coordinate. */
  private int x;
  /** This bubble's second coordinate. */
  private int y;

  private Paint paintText = new Paint();

  /** Constructs a new bubble at the specified cursor location (x, y). */
  Bubble(int x, int y) {
    // Get a nice-looking grey for the bubble
    paintText.setTextSize(36);
    paintText.setColor(Color.LTGRAY);
    paintText.setTypeface(Typeface.DEFAULT_BOLD);
    // start off with . as the appearance
    appearance = ".";
    setLocation(x, y);
  }

  /** Get x coordinate */
  int getX() {
    return this.x;
  }

  /** Get y coordinate */
  int getY() {
    return this.y;
  }

  /**
   * Set this item's location.
   *
   * @param a the first coordinate.
   * @param b the second coordinate.
   */
  public void setLocation(int a, int b) {
    // set x to a
    x = a;
    // set y to b
    y = b;
  }

  /**
   * Draws the given string in the given graphics context at at the given cursor location.
   *
   * @param canvas the graphics context in which to draw the string.
   * @param s the string to draw.
   * @param x the x-coordinate of the string's cursor location.
   * @param y the y-coordinate of the string's cursor location.
   */
  private void drawString(Canvas canvas, String s, int x, int y) {
    canvas.drawText(s, x * FishTankView.charWidth, y * FishTankView.charHeight, paintText);
  }

  /**
   * Draws this fish tank item.
   *
   * @param canvas the graphics context in which to draw this item.
   */
  public void draw(Canvas canvas) {
    drawString(canvas, appearance, x, y);
  }

  /** Move bubble straight up, left up or right up, randomly */
  public int[] move() {
    double direction = Math.random();
    y--;
    if (direction >= 0.66) {
      x -= 1;
    } else if (direction >= 0.33) {
      x += 1;
    }
    grow();
    return new int[] {}; // returns empty since no bubble is ever blown here
  }

  /** Randomly decide whether to grow the bubble * */
  private void grow() {
    // Generate random double
    double rd = Math.random();
    // Decide whether to grow or not using the random double
    if (rd < 0.05) {
      // If the appearance is a ., change it to an o
      if (appearance.equals(".")) appearance = "o";
      // If the appearance is an o, change it to a O
      else if (appearance.equals("o")) appearance = "O";
    }
  }
}
