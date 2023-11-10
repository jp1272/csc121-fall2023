import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class DailyRecordTest {

    DailyRecord dr = new DailyRecord();
    DailyRecord dr2 = new DailyRecord();
    
    @Test
    void test() {
        assertThrows(IllegalStateException.class, 
        				() -> dr.getHigh());

        assertEquals(Integer.MIN_VALUE, dr.getTemp(10));
        assertEquals(Integer.MIN_VALUE, dr.getTemp(9));
        
        //assertEquals(0, dr.getHigh());
        
        dr.recordTemp(10, 68);
        assertEquals(68, dr.getTemp(10));
        assertEquals(Integer.MIN_VALUE, dr.getTemp(9));
        
        assertEquals(68, dr.getHigh());

        dr.recordTemp(14, 73);
        dr.recordTemp(6, 59);
        dr.recordTemp(22, 62);
        dr.recordTemp(1, 1);

        assertEquals(73, dr.getHigh());
        assertEquals(1, dr.getLow());
        
        assertEquals(263/5, dr.getAverage());
        
        dr2.recordTemp(1, 1);
        
       assertEquals(1, dr2.getLow());
       assertEquals(1, dr2.getHigh());
       assertEquals(1, dr2.getAverage());
    }

}