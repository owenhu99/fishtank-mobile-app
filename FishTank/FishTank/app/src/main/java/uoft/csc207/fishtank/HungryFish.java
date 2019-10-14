package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class HungryFish extends FishTankItem {

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

  /** Causes this fish to blow a bubble. */
  private void blowBubble() {
    Bubble b = new Bubble(x, y);
    System.out.println(x + " " + y);

    FishTankManager.myLittleFishies.add(b);
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
  private void turnAround() {
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
    canvas.drawText(s, y * FishTankView.charWidth, x * FishTankView.charHeight, paintText);
  }

  /**
   * Draws this fish tank item.
   *
   * @param canvas the canvas on which to draw this item.
   */
  public void draw(Canvas canvas) {
    drawString(canvas, appearance, x, y);
  }

  /** Causes this item to take its turn in the fish-tank simulation. */
  public void move() {

    // Move one spot to the right or left.
    if (goingRight) {
      y += 1;
    } else {
      y -= 1;
    }

    // Figure out whether I blow a bubble.
    double d = Math.random();
    // If it's elss tahn 10%, blow a bubble.
    if (d < 0.1) {
      blowBubble();
    }

    // Figure out whether I turn around.
    d = Math.random();
    // If it's elss tahn 10%, turn around
    if (d < 0.1) {
      turnAround();
    }

    // Figure out whether to move up or down, or neither.
    d = Math.random();
    // If it's elss tahn 10%, move up or down.
    if (d < 0.1) {
      // Increment
      x += 1;
    } else if (d < 0.2) {
      // Decrement
      x -= 1;
    }
  }
}
