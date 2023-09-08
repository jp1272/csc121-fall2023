import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShapesTest {
    IShape s = new Square(new Posn(200,100), 50.0);
    IShape c = new Circle(new Posn(225,125), 25.0);

    Posn A = new Posn(100, 130); //  -> false (contained by s or c)
    Posn B = new Posn(220, 50);  //  -> false
    Posn C = new Posn(270, 140); //  -> false
    Posn D = new Posn(230, 170); //  -> false
    Posn E = new Posn(225, 120); //  -> true



    @Test
    public void testArea() {
        assertEquals(2500.0, this.s.area(), 0.1);
        assertEquals(1963.5, this.c.area(), 0.1);
    }

    @Test
    public void testInRange() {
        assertEquals(true, D.inRange(B, 40, 200));
        assertEquals(false, D.inRange(B, 5, 200));
        assertEquals(false, D.inRange(B, 30, 100));
    }

    @Test
    public void testContains() {
        assertEquals(false, this.s.contains(this.A));
        assertEquals(false, this.s.contains(this.B));
        assertEquals(false, this.s.contains(this.C));
        assertEquals(false, this.s.contains(this.D));
        assertEquals(true, this.s.contains(this.E));

        assertEquals(false, this.c.contains(this.A));
        assertEquals(false, this.c.contains(this.B));
        assertEquals(false, this.c.contains(this.C));
        assertEquals(false, this.c.contains(this.D));
        assertEquals(true, this.c.contains(this.E));
    }

}
