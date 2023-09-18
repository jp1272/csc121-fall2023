import processing.core.*;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class BouncyWorld {
    Posn anchor;
    Posn blob;
    int BOUNCE_FACTOR = 20;
    
    public BouncyWorld(Posn anchor, Posn blob) {
        this.anchor = anchor;
        this.blob = blob;
    }  

    /** produce an image of the state of this animation on given canvas */
    public PApplet draw(PApplet c) {
        c.background(255);  // clear the screen each time (color white)
        c.stroke(0);   // color black
        this.blob.drawLineTo(c, this.anchor);
        c.noStroke();  // no outline
        c.fill(255, 0, 0); // (R, G, B) = "red"
        c.circle(this.anchor.getX(), this.anchor.getY(), 10);
        c.imageMode(c.CENTER);
        c.image(c.loadImage("green_blob.gif"), this.blob.getX(), this.blob.getY());
        return c;
    }

    /** moves the blob if mouse pressed */
    public BouncyWorld mousePressed(MouseEvent mev) {
        return new BouncyWorld(this.anchor, new Posn(mev.getX(), mev.getY()));
    }
    
    /** moves the anchor in response to arrow keys */
    public BouncyWorld keyPressed(KeyEvent kev) {
        if (kev.getKeyCode() == PApplet.UP) {
            return new BouncyWorld(this.anchor.translate(new Posn(0, -10)), this.blob);
        } else if (kev.getKeyCode() == PApplet.DOWN) {
            return new BouncyWorld(this.anchor.translate(new Posn(0, 10)), this.blob);
        } else if (kev.getKeyCode() == PApplet.LEFT) {
            return new BouncyWorld(this.anchor.translate(new Posn(-10, 0)), this.blob);
        } else if (kev.getKeyCode() == PApplet.RIGHT) {
            return new BouncyWorld(this.anchor.translate(new Posn(10, 0)), this.blob);
        } else {
            return this;
        }
    }

    /** moves the blob proportionally closer to the anchor */
    public BouncyWorld update() {
        if (this.blob.distanceTo(this.anchor) < 2 * this.BOUNCE_FACTOR ) {
            return new BouncyWorld(this.anchor, this.anchor);  // snap to anchor
        } else {
            return new BouncyWorld(this.anchor,
                                this.blob.translate( this.blob.diff(this.anchor).scale( 1.0 / this.BOUNCE_FACTOR )));
        }
    }
    
}
