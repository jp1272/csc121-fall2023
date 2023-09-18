import java.util.Objects;

import processing.core.*;

public class Anchor {
    Posn loc;
    
    public Anchor(Posn loc) {
        this.loc = loc;
    }

    /** display on the PApplet canvas */
    public PApplet draw(PApplet c) {
        c.noStroke();  // no outline
        c.fill(255, 0, 0); // (R, G, B) = "red"
        c.circle(this.loc.getX(), this.loc.getY(), 10);
        return c;
    }
    

    /** draw a highlight around this anchor */
    public PApplet highlight(PApplet c) {
        c.noStroke();  // no outline
        c.fill(255, 255, 0); // (R, G, B) = "green-yellow"
        c.circle(this.loc.getX(), this.loc.getY(), 20);
        return c;        
    }
    
    /** moves this anchor by the given amount */
    public Anchor translate(Posn offset) {
        return new Anchor(this.loc.translate(offset));
    }
    
    /** produces the distance to the given posn */
    public double distanceTo(Posn p) {
        return this.loc.distanceTo(p);
    }

    @Override
    public String toString() {
        return "Anchor [loc=" + loc + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(loc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Anchor other = (Anchor) obj;
        return Objects.equals(loc, other.loc);
    }

}
