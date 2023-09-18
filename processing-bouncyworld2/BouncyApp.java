import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class BouncyApp extends PApplet {
    BouncyWorld w;
    
    public void settings() {
        this.size(400, 400);
    }
    
    public void setup() {
        w = new BouncyWorld(new Anchor(new Posn(50, 50)), 
                            new Anchor(new Posn(200, 200)),
                            new Blob(new Posn(100, 100)), 
                            true);
    }
    
    public void draw() {
        w = w.update();
        w.draw(this);
    }
    
    public void mousePressed(MouseEvent mev) {
        w = w.mousePressed(mev);
    }
    
    public void keyPressed(KeyEvent kev) {
        w = w.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "BouncyApp" }, new BouncyApp());
    }
}
