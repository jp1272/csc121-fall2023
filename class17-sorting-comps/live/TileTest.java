import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TileTest {

    Tile t1 = new Tile(10, 10, 50, 70, "A", Color.RED, 0);
    Tile t2 = new Tile(30, 70, 40, 40, "B", Color.BLUE, 10);
    Tile t3 = new Tile(0, 0, 10, 10, "C", Color.YELLOW, -TilesApp.BLINKSPEED);
    
    Tile[] tiles1 = new Tile[] { t1, t2, t3 };
    TileWorld tw1 = new TileWorld(tiles1);
    
    
    @Test
    void testCompare() {
    	assertEquals(  -1 , t1.compareTo(t2) );
    }
    
    
    @Test
    void testArrayList() {
    	
    	ArrayList<String> bldgs = new ArrayList<String>();
    	assertEquals( 0,  bldgs.size() );
    	assertEquals( true, bldgs.isEmpty() );
    	
    	bldgs.add("McAllister");    // 0
    	bldgs.add("Moon");			// 1
    	bldgs.add("Evans");			// 2
    	bldgs.add(0, "Krannert"); // inserts and shifts
    	bldgs.set(1, "MAC");  // replaces
    	
    	assertEquals( 4,  bldgs.size() );
    	assertEquals( false, bldgs.isEmpty() );

    	assertEquals( "Evans",  bldgs.get(3) );
    	
    	bldgs.remove(0);   // remove Krannert
    	assertEquals( "MAC",  bldgs.get(0) );
    	
    	bldgs.remove("Moon");
    	assertEquals( "Evans",  bldgs.get(1) );

    	
    	ArrayList<Integer> grades = new ArrayList<Integer>();
    	grades.add( 95 );
    	grades.add( 78 );
    	grades.add( 88 );
    	grades.add( 2 );
    	
    	//grades.remove(new Integer(2));
    }
    
    
    
    @Test
    void testContains() {
        assertTrue(t1.contains(10, 10));
        assertTrue(t1.contains(60, 80));
        assertTrue(t1.contains(45, 75));
        assertTrue(t1.contains(59, 79));
    
        assertFalse(t2.contains(1, 60));
        assertFalse(t1.contains(70, 75));
        assertFalse(t1.contains(40, 120));
        
        assertTrue(t2.contains(59, 79));
        assertTrue(t2.contains(70, 75));

        assertFalse(t2.contains(10, 10));
    }
    
    
    @Test
    void testSelect() {
        assertEquals(t2, tw1.select(59, 79));
        assertEquals(null, tw1.select(200, 300));
        assertEquals(new ArrayList<Tile>(Arrays.asList(t1, t2)), tw1.selectAll(59, 79));
        assertEquals(new ArrayList<Tile>(Arrays.asList(t1, t3)), tw1.selectAll(10, 10));
        assertEquals(new ArrayList<Tile>(), tw1.selectAll(300, 200));
    }
    
    
    @Test
    void testRaise() {
        assertEquals(t2, tw1.select(59, 79));
        assertEquals(t3, tw1.select(10, 10));
        
        tw1.raise(11, 11);  // t1

        assertEquals(t1, tw1.select(59, 79));
        assertEquals(t1, tw1.select(10, 10));

        tw1.raise(9, 9);
        
        assertEquals(t1, tw1.select(59, 79));
        assertEquals(t3, tw1.select(10, 10));
    }
    
    
    @Test
    void testLower() {
        assertEquals(t2, tw1.select(59, 79));
        assertEquals(t3, tw1.select(10, 10));
        
        tw1.lower(10, 10);  // t1

        assertEquals(t2, tw1.select(59, 79));
        assertEquals(t1, tw1.select(10, 10));

        tw1.lower(59, 79);
        
        assertEquals(t1, tw1.select(59, 79));
        assertEquals(t1, tw1.select(10, 10));
    }
    
    
    @Test
    void testDeleteAll1() {
        assertEquals(t2, tw1.select(59, 79));
        
        tw1.deleteAll(59, 79);
        assertEquals(null, tw1.select(59, 79));        
    }

    
    @Test
    void testDeleteAll2() {
        assertEquals(2, tw1.selectAll(59, 79).size());
        
        tw1.deleteAll(300, 300);
        assertEquals(2, tw1.selectAll(59, 79).size());
        
        tw1.deleteAll(10, 10);
        assertEquals(1, tw1.selectAll(59, 79).size());
    }


    @Test
    void testDelete() {
        assertEquals(t2, tw1.select(59, 79));
        assertEquals(t3, tw1.select(10, 10));
        
        tw1.delete(59, 79);
        
        assertEquals(t1, tw1.select(59, 79));        
        assertEquals(t3, tw1.select(10, 10));
    }


    
    
    @Test
    void testRearrange() {
        assertEquals(t3, tw1.select(6, 6));
        assertEquals(t1, tw1.select(11, 11));
        assertEquals(t2, tw1.select(40, 80));
        
        tw1.rearrange(5); // t1 at (5,5) ; t2 at (10,10) ; t3 at (15,15)
        
        assertEquals(t1, tw1.select(6, 6));
        assertEquals(t2, tw1.select(11, 11));
        assertEquals(t3, tw1.select(15, 15));
        assertEquals(null, tw1.select(40, 80));     // t2 moved
    }

}
