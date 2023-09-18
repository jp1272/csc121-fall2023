import java.util.Objects;

import processing.core.PApplet;

public class Posn {
    float x;
    float y;
    
    public Posn(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }
    
    /** draws a line from this point to that */
    public PApplet drawLineTo(PApplet c, Posn that) {
        c.line(this.x, this.y, that.x, that.y);

        return c;
    }
    
    /** produces the distance between this and that */
    public float distanceTo(Posn that) {
        return (float) Math.sqrt( Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2) );
    }
    
    /** produces this posn's coordinates multiplied by d */
    public Posn scale(float d) {
        return new Posn(this.x * d, this.y * d);
    }
    
    /** moves this posn by the given offsets */
    public Posn translate(Posn offset) {
        return new Posn( this.x + offset.x, this.y + offset.y );
    }

    /** produce the difference between that and this posn */
    public Posn diff(Posn that) {
        return new Posn( that.x - this.x,  that.y - this.y );
    }
    
    
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Posn other = (Posn) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public String toString() {
        return "Posn [x=" + x + ", y=" + y + "]";
    }

}
