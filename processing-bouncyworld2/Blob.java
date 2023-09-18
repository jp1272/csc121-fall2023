import java.util.Objects;

import processing.core.*;
import processing.event.*;

public class Blob {
    Posn loc;
    int BOUNCE_FACTOR = 40;
    
    public Blob(Posn loc) {
        this.loc = loc;
    }
    
    public PApplet draw(PApplet c, Anchor a) {
        c.stroke(0);   // color black
        this.loc.drawLineTo(c, a.loc);
        c.imageMode(c.CENTER);
        c.image(c.loadImage("green_blob.gif"), this.loc.getX(), this.loc.getY());
        return c;
    }
    
    /** moves this blob closer to the given anchor */
    public Blob moveTowards(Anchor a) {
        if (a.distanceTo(this.loc) < (2.0f / this.BOUNCE_FACTOR) ) {
            return new Blob(a.loc);  // snap to anchor
        } else {
            return new Blob(this.loc.translate( this.loc.diff(a.loc).scale( 1.0f / this.BOUNCE_FACTOR )));
        }
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(BOUNCE_FACTOR, loc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Blob other = (Blob) obj;
        return BOUNCE_FACTOR == other.BOUNCE_FACTOR && Objects.equals(loc, other.loc);
    }

    @Override
    public String toString() {
        return "Blob [loc=" + loc + ", BOUNCE_FACTOR=" + BOUNCE_FACTOR + "]";
    }
}
