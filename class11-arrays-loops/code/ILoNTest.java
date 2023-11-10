import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ILoNTest {

    ILoN mt = new MTLoN();
    
    ILoN one = new ConsLoN(1, mt);
    ILoN oneExt = new ConsLoN(1, new ConsLoN(0, new ConsLoN(0, new ConsLoN(5, mt))));

    ILoN few = new ConsLoN(4, new ConsLoN(2, new ConsLoN(6, mt)));
    ILoN fewDiff = new ConsLoN(4, new ConsLoN(7, new ConsLoN(5, mt)));
    ILoN fewExt = new ConsLoN(4, new ConsLoN(2, new ConsLoN(6, new ConsLoN(0, new ConsLoN(8, mt)))));
    
    
    @Test
    void testSetValueOne() {
        assertNotEquals(new ConsLoN(5, mt), one);
        
        // setting the first value to 5 returns a list of one thing 
        assertEquals(new ConsLoN(5, mt),  one.setValue(0, 5));
        
        // but also *mutates* one itself, so now:
        assertEquals(new ConsLoN(5, mt), one);
    }
    
    @Test
    void testSetValueExtend() {
        assertNotEquals(oneExt,  one);
        
        // extension (fills in with 0's)
        one.setValue(3, 5);   // this mutates as well as returns the list
        
        assertEquals(oneExt,  one);
    }
    
    @Test
    void testSetValueFew() {
        assertNotEquals(fewDiff, few);
        
        few.setValue(2, 5).setValue(1, 7);
        
        assertEquals(fewDiff, few);
    }
    
    @Test
    void testSetValueExt() {
        assertNotEquals(fewExt, few);
        
        few.setValue(4, 8);
        
        assertEquals(fewExt, few);
    }
    
    @Test
    void testGetValue() {
        // any attempts to getValue of  mt  should result in an IllegalArgumentException being thrown
        assertThrows(IllegalStateException.class, () -> mt.getValue(0));
        assertThrows(IllegalStateException.class, () -> mt.getValue(6));
        
        // ok results
        assertEquals(6, fewExt.getValue(2));
        assertEquals(1, one.getValue(0));
        
        // but out-of-bounds positions result in exception too
        assertThrows(IllegalStateException.class, () -> one.getValue(3));
        assertThrows(IllegalStateException.class, () -> fewExt.getValue(300));
    }

}
