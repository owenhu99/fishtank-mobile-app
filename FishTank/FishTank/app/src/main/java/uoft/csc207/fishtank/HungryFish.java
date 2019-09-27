package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class HungryFish {

    /** How this fish appears on the screen. */
    public String appearance;

    /** Indicates whether this fish is moving right. */
    boolean goingRight;

    /** This fish's first coordinate. */
    int r;
    /** This fish's second coordinate. */
    int c;
    private Paint paintText = new Paint();


    /**
     * Constructs a new hungry fish.
     */
    public HungryFish() {
        appearance = "><MEHUNGRY>";
        paintText.setTextSize(36);
        paintText.setColor(Color.CYAN);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        goingRight = true;
    }


    /**
     * Set this item's location.
     * @param a the first coordinate.
     * @param b  the second coordinate.
     */
    public void setLocation(int a, int b) {
        r = a;
        c = b;
    }



    /**
     * Causes this fish to blow a bubble.
     */
    protected void blowBubble() {
        Bubble b = new Bubble();
        b.setLocation(c, r);
        System.out.println(r + " " + c);

        FishTankManager.myLittleFishies[r][c] = b;
    }



    /**
     * Build and initialize this fish's forward and backward
     * appearances.
     */
    private String reverseAppearance() {
        System.out.println("Turnign around" + this.appearance);
        String reverse = "";
        for (int i=appearance.length()-1; i>=0; i--) {
            switch (appearance.charAt(i)) {
                case ')': reverse += '('; break;
                case '(': reverse += ')'; break;
                case '>': reverse += '<'; break;
                case '<': reverse += '>'; break;
                case '}': reverse += '{'; break;
                case '{': reverse += '}'; break;
                case '[': reverse += ']'; break;
                case ']': reverse += '['; break;
                default: reverse += appearance.charAt(i); break;
            }
        }
        System.out.println("Turned around" + this.appearance);
        appearance = reverse;
        return reverse;
    }


    /**
     * Turns this fish around, causing it to reverse direction.
     */
    protected void turnAround() {
        goingRight = !goingRight;
        if (goingRight) {
            appearance = reverseAppearance();
        } else {
            appearance = reverseAppearance();
        }
    }


    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param  canvas  the canvas on which to draw this item.
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
     * @param  canvas  the canvas on which to draw this item.
     */
    public void draw(Canvas canvas) {
        drawString(canvas, appearance, r, c);
    }



    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void move() {

        // Move one spot to the right or left.
        if (goingRight) {
            c += 1;
        } else {
            c -= 1;
        }

        // Figure out whether I blow a bubble.
        double d = Math.random();
        // If it's elss tahn 10%, blow a bubble.
        if (d < 0.1) { blowBubble(); }

        // Figure out whether I turn around.
        d = Math.random();
        // If it's elss tahn 10%, turn around
        if (d < 0.1) { turnAround(); }

        // Figure out whether to move up or down, or neither.
        d = Math.random();
        // If it's elss tahn 10%, move up or down.
        if (d < 0.1) {
            // Increment
            r += 1;
        } else if (d < 0.2) {
            // Decrement
            r -= 1;
        }
    }
}
