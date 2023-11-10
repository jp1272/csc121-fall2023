import java.awt.Color;
import java.util.Comparator;
import java.util.Objects;

import processing.core.PApplet;

/*
class NameComparator implements Comparator<Tile> {
	/** compares two tiles based on name * /
	@Override
	public int compare(Tile t1, Tile t2) {
		return t1.compareTo(t2);  // uses the "natural ordering" on tiles
	}
}

class AreaComparator implements Comparator<Tile> {
	@Override
	public int compare(Tile t1, Tile t2) {
		return t1.area() - t2.area();
	}
}
*/



/** 
 * Represents a rectangular tile on the window
 */
public class Tile implements Comparable<Tile> { /* "natural ordering" */
    // top-left
    private int x;
    private int y;
    
    // size
    private int width;
    private int height;
    
    // contents
    private String name;
    private Color color;
    private int blinkCounter;   // when positive, showing; when negative, not showing; moves towards zero


    public Tile(int x, int y, int width, int height, String name, Color color, int blinkCounter) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
        this.color = color;
        this.blinkCounter = blinkCounter;
    }

    
    public Tile(int x, int y, int width, int height) {
        this(x, y, width, height,
             Character.toString((char)(Math.random() * 26 + 'A'))
                 + Character.toString((char)(Math.random() * 26 + 'a')),
             new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)),
             TilesApp.BLINKSPEED);
    }


    public Tile(int x, int y) {
        this(x, y,
             (int)(Math.random() * (TilesApp.WIDTH - x)),
             (int)(Math.random() * (TilesApp.WIDTH - y)));
    }
    
    
    public Tile() {
        this((int)(Math.random() * TilesApp.WIDTH), (int)(Math.random() * TilesApp.HEIGHT));
    }
    
    
    /** does this tile contain the given point */
    public boolean contains(int x, int y) {
        return (this.x <= x && x <= (this.x + this.width) 
                && this.y <= y && y <= (this.y + this.height));
    }
    
    
    /** update this tile's blink counter */
    public void update() {
        this.blinkCounter--;  // decrement
        if (this.blinkCounter <= - TilesApp.BLINKSPEED)
            this.blinkCounter = TilesApp.BLINKSPEED;
    }
    
    
    /** draw this tile */
    public void draw(PApplet c) {
        c.fill(this.color.getRGB());
        c.stroke(0);   // always black
        c.rect(this.x, this.y, this.width, this.height);   
        if (this.blinkCounter > 0) {
            c.fill(0);
            c.textSize(18);
            c.text(this.name, this.x + 12, this.y + 24);
        }
    }
    
    
    /** moves this tile by the given offsets */
    public void moveBy(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    
    /** moves this tile to the given top-left corner */
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }



    @Override
    public int hashCode() {
        return Objects.hash(height, width, x, y);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tile other = (Tile) obj;
        return height == other.height && width == other.width && x == other.x && y == other.y;
    }


    @Override
    public String toString() {
        return "Tile [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
    }

    
    /** 
     * produces the area of this tile
     */
    public int area() {
    	return this.width * this.height;
    }
    
    
    /**
     * Compares this tile's area to the other's
    
	@Override
	public int compareTo(Tile other) {
		return this.area() - other.area();
	}
	*/
    

    /**
     * Compares this tile's name to the other's
     */
	@Override
	public int compareTo(Tile other) {
		return this.name.compareTo( other.name );
	}
    
}
