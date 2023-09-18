import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/*
  Sample mobiles:
  ---------------
  
  simple1:
                     |
                     |
                     10
                    blue
  
  complex2 (with complex1 on the left and simple2 on the right)
                 complex1 (with simple3 on the left, simple1 on the right)
  
                         |
                         |
                         |
             ------------+------
             |                 |
       ------+------           |
       |           |           | 
       10          |           40    
      red          10         green
                  blue
                  
                  
   complex3
                        |
                        |
                        |
                  ------+----------------
                  |                     |
                  |                     |
                  2                     |
                yellow             -----+-------
                                   |           |
                                   5           |
                                  pink         7
                                             black
*/

import static java.awt.Color.*;

class IMobileTest {
    
    IMobile simple1 = new Simple(20, 10, BLUE);
    IMobile simple2 = new Simple(30, 40, GREEN);
    IMobile simple3 = new Simple(10, 10, RED);

    IMobile complex1 = new Complex(10, 5, 5, this.simple3, this.simple1);
    IMobile complex2 = new Complex(30, 10, 5, this.complex1, this.simple2);
    
    IMobile complex3 = new Complex(30, 5, 15,
                                   new Simple(20, 2, YELLOW),
                                   new Complex(30, 4, 6,
                                               new Simple(10, 5, PINK),
                                               new Simple(20, 7, BLACK)));
    
    /*
    @Test
    void testTotalWeight() {
        assertEquals(10, this.simple1.totalWeight());
        assertEquals(20, this.complex1.totalWeight());
        assertEquals(60, this.complex2.totalWeight());
        assertEquals(14, this.complex3.totalWeight());
    }
    
    @Test
    void testHeight() {
        assertEquals(20, simple1.height());
        assertEquals(60, complex2.height());
        assertEquals(80, complex3.height());
    }
    
    @Test
    void testTorque() {
        assertEquals(0, simple2.torque());
        assertEquals(0, complex1.torque());
        assertEquals(0, complex2.torque());
        assertEquals(170, complex3.torque());
    }
    
    @Test
    void testIsBalanced() {
        assertTrue(simple2.isBalanced());
        assertTrue(complex1.isBalanced());
        assertTrue(complex2.isBalanced());
        assertFalse(complex3.isBalanced());
        assertFalse(new Complex(20, 5, 5, complex3, complex3).isBalanced());
    }
    */
}
