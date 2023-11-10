import java.util.Comparator;

import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class TilesApp extends PApplet {
    /* overall application constants */
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public static final int BLINKSPEED = 25;
    
    //public static final Comparator<Tile> NAME_C = new NameComparator();
    //public static final Comparator<Tile> AREA_C = new AreaComparator();

    public static final Comparator<Tile> NAME_C = new Comparator<Tile>() {
    	/** compares two tiles based on name */
    	public int compare(Tile t1, Tile t2) {
    		return t1.compareTo(t2);  // uses the "natural ordering" on tiles
    	}
    };
    		
    public static final Comparator<Tile> AREA_C = new Comparator<Tile>() {
    	public int compare(Tile t1, Tile t2) {
    		return t1.area() - t2.area();
    	}
    };
    
    
    /* fields */
    private TileWorld w;
    
    public void settings() {
        this.size(WIDTH, HEIGHT);
    }
    
    public void setup() {
        w = new TileWorld();
    }
    
    public void draw() {
        w.update();
        w.draw(this);
    }
    
    public void mousePressed(MouseEvent mev) {
        w.mousePressed(mev);
    }
    
    public void mouseReleased(MouseEvent mev) {
        w.mouseReleased(mev);
    }

    public void mouseMoved(MouseEvent mev) {
        w.mouseMoved(mev);
    }
    
    public void mouseDragged(MouseEvent mev) {
        w.mouseDragged(mev);
    }

    public void mouseEntered(MouseEvent mev) {
        w.mouseEntered(mev);
    }

    public void mouseExited(MouseEvent mev) {
        w.mouseExited(mev);
    }

    
    public void keyPressed(KeyEvent kev) {
        w.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "TilesApp" }, new TilesApp());
    }
}
