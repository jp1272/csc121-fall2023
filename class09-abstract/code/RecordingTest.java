import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RecordingTest {
 
    Pressure p1 = new Pressure(1200, 1015, 900);
    Temperature t1 = new Temperature(75, 65, 50);
    //ATemperature t1 = new Fahrenheit(75, 65, 50);
    
    @Test
    public void testDiffs() {
      assertEquals(185, this.p1.diffFromHigh());
      assertEquals(115, this.p1.diffFromLow());
      assertEquals(10, this.t1.diffFromHigh());
      assertEquals(15, this.t1.diffFromLow());
    }
    
    @Test
    public void testAsString() {
      assertEquals("1200-900hPa", this.p1.asString());
      assertEquals("75-50F", this.t1.asString());   
      //assertEquals("75-50 degrees Fahrenheit", this.t1.asString());    
    }

}
