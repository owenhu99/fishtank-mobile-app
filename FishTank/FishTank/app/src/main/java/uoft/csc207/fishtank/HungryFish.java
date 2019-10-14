package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class HungryFish extends FishTankItem implements Turnable {

  /** How this fish appears on the screen. */
  private String appearance;

  /** Indicates whether this fish is moving right. */
  private boolean goingRight;

  /** This fish's first coordinate. */
  private int x;
  /** This fish's second coordinate. */
  private int y;

  private Paint paintText = new Paint();

  /** Constructs a new hungry fish. */
  HungryFish(int x, int y) {
    appearance = "><MEHUNGRY>";
    paintText.setTextSize(36);
    paintText.setColor(Color.CYAN);
    paintText.setTypeface(Typeface.DEFAULT_BOLD);
    goingRight = true;
    setLocation(x, y);
  }

  /** Get x coordinate */
  int getX () {
    return this.x;
  }

  /** Get y coordinate */
  int getY () {
    return this.y;
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

  /** Build and initialize this fish's forward and backward appearances. */
  private String reverseAppearance() {
    StringBuilder reverse = new StringBuilder(appearance).reverse();
    for (int i = 0; i < reverse.length(); i++) {
      if (reverse.charAt(i) == '<') {
        reverse.setCharAt(i, '>');
      } else if (reverse.charAt(i) == '>') {
        reverse.setCharAt(i, '<');
      }
    }
    return reverse.toString();
  }

  /** Turns this fish around, causing it to reverse direction. */
  public void turnAround() {
    goingRight = !goingRight;
    System.out.println("Turning around" + this.appearance);
    appearance = reverseAppearance();
    System.out.println("Turned around" + this.appearance);
  }

  /**
   * Draws the given string in the given graphics context at at the given cursor location.
   *
   * @param canvas the canvas on which to draw this item.
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
   * @param canvas the canvas on which to draw this item.
   */
  public void draw(Canvas canvas) {
    drawString(canvas, appearance, x, y);
  }

  /**
   * Causes this item to take its turn in the fish-tank simulation.
   * Returns array of x and y coordinates if a bubble is blown
   */
  public int[] move() {
    // Figure out whether I turn around.
    double d = Math.random();
    // If it's less than 10%, turn around
    if (d < 0.1) {
      turnAround();
    }

    // Move one spot to the right or left.
    if (goingRight) {
      x += 1;
    } else {
      x -= 1;
    }

    // Figure out whether to move up or down, or neither.
    d = Math.random();
    // If it's less than 10%, move up or down.
    if (d < 0.1) {
      // Increment
      y += 1;
    } else if (d < 0.2) {
      // Decrement
      y -= 1;
    }

    // If it's less than 10%, blow a bubble.
    if (d < 0.1) {
      System.out.println(x + " " + y);
      return new int[]{x, y}; // return current coordinates
    } else {
      return new int[]{}; // return empty array denoting no bubble blown
    }
  }
}
