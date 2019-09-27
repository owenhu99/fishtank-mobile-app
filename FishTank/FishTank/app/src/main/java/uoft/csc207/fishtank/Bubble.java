package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * A bubble.
 */
public class Bubble {

    /** How this bubble appears on the screen. */
    private String appearance;

    /** Use for random movement left and right.  */
    public double d;

    /** This bubble's first coordinate. */
    int x;
    /** This bubble's second coordinate. */
    protected int y;

    private Paint paintText = new Paint();

    /**
     * Constructs a new bubble at the specified cursor location (x, y).
     */
    public Bubble() {
        // Get a nice-looking grey for the bubble
        paintText.setTextSize(36);
        paintText.setColor(Color.LTGRAY);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        // start off with . as the appearance
        appearance = ".";
    }

    /**
     * Set this item's location.
     * @param a the first coordinate.
     * @param b  the second coordinate.
     */
    public void setLocation(int a, int b) {
        // set x to a
        x = a;
        // set y to b
        y = b;
    }

    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param  canvas  the graphics context in which to draw the string.
     * @param  s  the string to draw.
     * @param  x  the x-coordinate of the string's cursor location.
     * @param  y  the y-coordinate of the string's cursor location.
     */
    void drawString(Canvas canvas, String s, int x, int y) {
        canvas.drawText(s, y * FishTankView.charWidth, x * FishTankView.charHeight, paintText);
    }


    /**
     * Draws this fish tank item.
     *
     * @param  canvas  the graphics context in which to draw this item.
     */
    public void draw(Canvas canvas) {
        drawString(canvas, appearance, y, x);
    }



    /**
     * Causes this item to take its turn in the fish-tank simulation, moving straight up.
     */
    public void floatStraightUp() {

        // Move upwards.
        y--;
        x = x; // no change left or right

        // Figure out whether to grow, if at all.
        d = Math.random();
        // Oocasinally change a . to a o or a o to a O
        if (d < 0.05) {
            // If the appearance is a ., change it to an o
            if (appearance.equals("."))appearance="o";
                // If the appearance is an o, change it to a O
            else if (appearance.equals("o"))appearance="O";
        }
    }    /**
     * Causes this item to take its turn in the fish-tank simulation, moving up and left.
     */
    public void floatLeftUp() {

        // Move upwards.
        y--;
        x -= 1; //left

        // Figure out whether to grow, if at all.
        d = Math.random();
        // Oocasinally change a . to a o or a o to a O
        if (d < 0.05) {
            // If the appearance is a ., change it to an o
            if (appearance.equals(".")) appearance = "o";
                // If the appearance is an o, change it to a O
            else if (appearance.equals("o")) appearance = "O";
        }
    }
    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void floatRightUp() {

        // Move upwards.
        y--;
        x += 1;// right
        // Figure out whether to grow, if at all.
        d = Math.random();
        // Oocasinally change a . to a o or a o to a O
        if (d < 0.05) {
            // If the appearance is a ., change it to an o
            if (appearance.equals("."))appearance="o";
                // If the appearance is an o, change it to a O
            else if (appearance.equals("o"))appearance="O";
        }
    }
}
