package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class Seaweed extends FishTankItem {
  private Paint paintText = new Paint();

  /** The number of weed segments. */
  private int l;

  /** Indicates whether the bottom segment is leaning right. */
  private boolean leanRight;

  /** This bubble's first coordinate. */
  private int x;

  /** This bubble's second coordinate. */
  private int y;

  /**
   * Constructs a new seaweed item at the specified cursor location (x,y),l segments tall.
   *
   * @param x the x coordinate of the bubble's cursor location.
   * @param y the y coordinate of the bubble's cursor location.
   * @param l the number of segments this seaweed is tall.
   */
  Seaweed(int x, int y, int l) {
    this.l = l;
    setLocation(x, y);
    paintText.setTextSize(36);
    paintText.setColor(Color.GREEN);
    paintText.setTypeface(Typeface.DEFAULT_BOLD);
  }

  /**
   * Draws this fish tank item. Looks lovely waving in the current, doesn't it?
   *
   * @param canvas the graphics context in which to draw this item.
   */
  public void draw(Canvas canvas) {
    for (int i = 0; i < l; i++) {
      // For even numbered segment
      if (i % 2 == 0) {
        if (leanRight) {
          // Bottom leaning right
          drawString(canvas, "/", x, y - i);
        } else {
          // Bottom leaning left
          drawString(canvas, "\\", x, y - i);
        }
      }
      // For odd numbered segment
      else {
        if (leanRight) {
          // Bottom leaning right
          drawString(canvas, "\\", x, y - i);
        } else {
          // Bottom leaning left
          drawString(canvas, "/", x, y - i);
        }
      }
    }
  }
  /**
   * Draws the given string in the given graphics context at at the given cursor location.
   *
   * @param canvas where to draw the string.
   * @param s the string to draw.
   * @param x the x-coordinate of the string's cursor location.
   * @param y the y-coordinate of the string's cursor location.
   */
  private void drawString(Canvas canvas, String s, int x, int y) {
    canvas.drawText(s, x * FishTankView.charWidth, y * FishTankView.charHeight, paintText);
  }

  /**
   * Set this item's location.
   *
   * @param a the first coordinate.
   * @param b the second coordinate.
   */
  public void setLocation(int a, int b) {
    x = a;
    y = b;
  }

  /** Causes this item to take its turn in the fish-tank simulation. */
  public int[] move() {
    leanRight = !leanRight;
    return new int[]{}; // returns empty since no bubble is ever blown here
  }
}
