
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// goes with runnerlog2.java

public class LogTests2 {

  Date d1 = new Date(5, 5, 2003);
  Date d2 = new Date(6, 6, 2003);
  Date d3 = new Date(23, 6, 2003);
  
  Entry e1 = new Entry(d1, 5.0, 25, "Good");
  Entry e2 = new Entry(d2, 3.0, 24, "Tired");
  Entry e3 = new Entry(d3, 26.0, 156, "Great");
  
  ILog l1 = new MTLog();
  ILog l2 = new ConsLog(e1, l1);
  ILog l3 = new ConsLog(e2, l2);
  ILog l4 = new ConsLog(e3, l3);
  
  @Test
  void testMiles() {
    assertEquals(l1.miles(), 0.0, 0.01);  // to within 1% accuracy
    assertEquals(l2.miles(), 5.0, 0.01);
    assertEquals(l3.miles(), 8.0, 0.01);
    assertEquals(l4.miles(), 34.0, 0.01);
  }
}