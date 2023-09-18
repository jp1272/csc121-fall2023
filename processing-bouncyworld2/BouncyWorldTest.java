import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BouncyWorldTest {

    Blob b1 = new Blob(new Posn(100, 100));
    Anchor a1 = new Anchor(new Posn(102, 102));
    
    
    @Test
    void testBlob() {
        // moveTowards
        assertEquals(new Blob(new Posn(100.05f, 100.05f)),
                     b1.moveTowards(a1));
        assertEquals(new Blob(new Posn(102, 102)),
                new Blob(new Posn(102.01f, 101.99f)).moveTowards(a1));
    }
    
    
    @Test
    void testAnchor() {
        // translate
        assertEquals(new Anchor(new Posn(105, 90)),
                a1.translate(new Posn(3, -12)));
        
        // distanceTo
        assertEquals(5, a1.distanceTo(new Posn(105, 98)));
        assertEquals(10, a1.distanceTo(new Posn(112, 102)));
    }
    
    
    @Test
    void testPosn() {
        assertEquals(new Posn(2, 2),
            new Posn(100, 100).diff(new Posn(102, 102)));
        assertEquals(new Posn(.05f, .05f),
                new Posn(2, 2).scale(1.0f/40));
    }

}
