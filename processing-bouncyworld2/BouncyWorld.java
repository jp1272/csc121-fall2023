import processing.core.*;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class BouncyWorld {
    Anchor a1;
    Anchor a2;
    Blob bob;
    boolean isPaused;
        
    public BouncyWorld(Anchor a1, Anchor a2, Blob bob, boolean isPaused) {
        this.a1 = a1;
        this.a2 = a2;
        this.bob = bob;
        this.isPaused = isPaused;
    }

    /** produce an image of the state of this animation on given canvas */
    public PApplet draw(PApplet c) {
        c.background(135, 206, 250);  // clear the screen each time (color sky blue)
        this.a1.highlight(c);    // a1 is always the 'active' anchor
        this.a1.draw(c);
        this.a2.draw(c);
        this.bob.draw(c, closerAnchor(this.bob.loc));
        return c;
    }
    
    /** produce the closer of the two anchors to the given posn */
    public Anchor closerAnchor(Posn p) {
        if (this.a1.distanceTo(p) < this.a2.distanceTo(p)) {
            return this.a1;
        } else {
            return this.a2;
        }
    }

    /** moves the blob if mouse pressed */
    public BouncyWorld mousePressed(MouseEvent mev) {
        return new BouncyWorld(this.a1, this.a2, new Blob(new Posn(mev.getX(), mev.getY())), this.isPaused);
    }
    
    /** moves the anchor in response to arrow keys */
    public BouncyWorld keyPressed(KeyEvent kev) {
        if (kev.getKeyCode() == PApplet.UP) {
            return new BouncyWorld(this.a1.translate(new Posn(0, -10)), this.a2, this.bob, this.isPaused);
        } else if (kev.getKeyCode() == PApplet.DOWN) {
            return new BouncyWorld(this.a1.translate(new Posn(0, 10)), this.a2, this.bob, this.isPaused);
        } else if (kev.getKeyCode() == PApplet.LEFT) {
            return new BouncyWorld(this.a1.translate(new Posn(-10, 0)), this.a2, this.bob, this.isPaused);
        } else if (kev.getKeyCode() == PApplet.RIGHT) {
            return new BouncyWorld(this.a1.translate(new Posn(10, 0)), this.a2, this.bob, this.isPaused);
        } else if (kev.getKeyCode() == PApplet.TAB) {
            return new BouncyWorld(this.a2, this.a1, this.bob, this.isPaused);
        } else if (kev.getKey() == ' ') {  // space
            return new BouncyWorld(this.a1, this.a2, this.bob, ! this.isPaused);
        } else {
            return this;
        }
    }

    /** moves the blob proportionally closer to the anchor */
    public BouncyWorld update() {
        if (isPaused) {
            return this;
        } else {    
            return new BouncyWorld(this.a1, this.a2,
                                this.bob.moveTowards(closerAnchor(this.bob.loc)),
                                this.isPaused);
        }
    }
    
}
