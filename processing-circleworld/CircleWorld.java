import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Represents an interactive application where a drop of
 * water falls down from the top of the window. If the 
 * user clicks the mouse, the drop is moved over to the
 * location of the click;
 */
public class CircleWorld {
    // the position of the drop
    double x;
    double y;

    public CircleWorld(double x, double y) {
        this.x = x;
        this.y = y; 
    }
    
    /**
     * Renders a picture of the drop on the window
     */
    public PApplet draw(PApplet c) {
        c.background(255);
        c.fill(0, 0, 255);
        c.circle((int)this.x, (int)this.y, 15);
        return c;
    }

    /**
     * Produces an updated world where the drop moves
     * down a little bit, if it hasn't hit the bottom
     * of the screen yet.
     */
    public CircleWorld update() {
        if (this.y < 400) {
            return new CircleWorld(this.x, this.y + .5);
        } else {
            return this;
        }
    }
    
    /**
     * Produces an updated world with the position of the
     * drop updated to the location of the mouse press.
     */
    public CircleWorld mousePressed(MouseEvent mev) {
        return new CircleWorld(mev.getX(), mev.getY());
    }
    
    /**
     * Produces a string rendering of the position of the
     * drop
     */
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
