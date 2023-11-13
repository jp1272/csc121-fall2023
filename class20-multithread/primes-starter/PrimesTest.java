import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimesTest {
    
    PrimeComputer pc = new PrimeComputer();
    //PrimeComputerThreaded pct = new PrimeComputerThreaded();

    @Test
    void testIsPrime() {
        assertTrue( pc.isPrime(7) );
        assertTrue( pc.isPrime(999883) );
        assertFalse( pc.isPrime( 9 ));
        assertFalse( pc.isPrime( 0 ));
        assertFalse( pc.isPrime( 275253 ));
    }
    
    
    @Test
    void testComputeTo() {
        assertArrayEquals(new int[] {2,3,5,7}, pc.computeTo(10));
        assertArrayEquals(new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97}, pc.computeTo(100));
        assertArrayEquals(new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101}, pc.computeTo(101));
    }

    /*
    @Test
    void testComputeToThreaded() {
        assertArrayEquals(new int[] {2,3,5,7}, pct.computeTo(10));
        assertArrayEquals(new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97}, pct.computeTo(100));
        assertArrayEquals(new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101}, pct.computeTo(101));
    }
    */

}
