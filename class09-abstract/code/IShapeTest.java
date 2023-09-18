import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IShapeTest {

    IShape dot = new Dot(new CartPt(4, 3));
    IShape squ = new Square(new CartPt(4, 3), 3);
    IShape cir = new Circle(new CartPt(12, 5), 2);

    @Test
    public void testArea() {
        assertEquals(this.dot.area(), 0.0, 0.01);
        assertEquals(this.squ.area(), 9.0, 0.01);
        assertEquals(this.cir.area(), 12.56, 0.01);
    }

    @Test
    public void testLargerThan() {
        assertEquals(this.dot.largerThan(this.squ), false);
        assertEquals(this.squ.largerThan(this.dot), true);
        assertEquals(this.squ.largerThan(this.cir), false);
        assertEquals(this.cir.largerThan(this.squ), true);
    }

    @Test
    public void testDistTo0() {
        assertEquals(new CartPt(4, 3).distTo0(), 5.0, 0.01);
        assertEquals(new CartPt(12, 5).distTo0(), 13.0, 0.01);

        assertEquals(this.dot.distTo0(), 5.0, 0.01);
        assertEquals(this.squ.distTo0(), 5.0, 0.01);
        assertEquals(this.cir.distTo0(), 11.0, 0.01);
    }
}
