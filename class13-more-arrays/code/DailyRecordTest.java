

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class DailyRecordTest {
    

    @Test
    void testArbitraryDailyRecords() {
        testSetArbitrary(new BasicDailyRecord());
        //testSetArbitrary(new ParallelDailyRecord());
    }
    
    @Test
    void testSeqDailyRecords() {
        //testSetSequential(new SeqDailyRecord());
    }

    
    /* 
     * Tests implementations of IDailyRecord that require
     * recording hour daily in sequential order, i.e.
     * you cannot record a temperature for hour h until readings for
     * hours 0...(h-1) have been recorded.
 
     * If hours 0...(h-1) have been recorded, you can *rerecord* a temperature
     * for any hour h' < h.
     * 
     * This method should be called with an initially 
     * empty daily record
     */
    void testSetSequential(IDailyRecord dr) {
        assertThrows(IllegalArgumentException.class, () -> dr.getTemp(10));
        assertThrows(IllegalArgumentException.class, () -> dr.getTemp(21));
        assertThrows(IllegalStateException.class, () -> dr.getHigh());
        assertThrows(IllegalStateException.class, () -> dr.getLow());
        assertThrows(IllegalStateException.class, () -> dr.getAverage());
                
        // not sequential...
        assertThrows(IllegalArgumentException.class, () -> dr.recordTemp(10, 68));
        
        dr.recordTemp(0, 68);
        assertEquals(68, dr.getTemp(0));
        assertThrows(IllegalArgumentException.class, () -> dr.getTemp(21)); // not affected
        
        assertEquals(68, dr.getHigh());
        assertEquals(68, dr.getLow());
        assertEquals(68, dr.getAverage());

        dr.recordTemp(1, 73);
        dr.recordTemp(2, 59);
        dr.recordTemp(3, 62);

        assertEquals(73, dr.getHigh());
        assertEquals(59, dr.getLow());
        assertEquals(65, dr.getAverage());  
        
        dr.recordTemp(1, 62);   // change
        assertEquals(68, dr.getHigh());
        assertEquals(59, dr.getLow());
        assertEquals(62, dr.getAverage());  
    }
    
    
    /* 
     * Tests implementations of IDailyRecord that allow 
     * setting hourly data in arbitrary order 
     * 
     * This method should be called with an initially 
     * empty daily record
     */
    void testSetArbitrary(IDailyRecord dr) {
        assertThrows(IllegalArgumentException.class, () -> dr.getTemp(10));
        assertThrows(IllegalArgumentException.class, () -> dr.getTemp(21));
        assertThrows(IllegalStateException.class, () -> dr.getHigh());
        assertThrows(IllegalStateException.class, () -> dr.getLow());
        assertThrows(IllegalStateException.class, () -> dr.getAverage());

        assertThrows(IllegalArgumentException.class, () -> dr.recordTemp(-3, 83)); // invalid hour
        assertThrows(IllegalArgumentException.class, () -> dr.recordTemp(24, 75)); // invalid hour
        assertThrows(IllegalArgumentException.class, () -> dr.recordTemp(27, 71)); // invalid hour
        
        dr.recordTemp(10, 68);
        assertEquals(68, dr.getTemp(10));
        assertThrows(IllegalArgumentException.class, () -> dr.getTemp(21)); // not affected
        
        assertEquals(68, dr.getHigh());
        assertEquals(68, dr.getLow());
        assertEquals(68, dr.getAverage());

        dr.recordTemp(14, 73);
        dr.recordTemp(6, 59);
        dr.recordTemp(22, 62);

        assertEquals(73, dr.getHigh());
        assertEquals(59, dr.getLow());
        assertEquals(65, dr.getAverage());
        
        dr.recordTemp(14, 62);   // change
        assertEquals(68, dr.getHigh());
        assertEquals(59, dr.getLow());
        assertEquals(62, dr.getAverage());  

    }

}
