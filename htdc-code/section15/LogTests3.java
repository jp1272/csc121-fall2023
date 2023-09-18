
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// goes with runnerlog3.java

class LogTests3 {
  
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
  ILog l5 =
    new ConsLog(new Entry(new Date(1,2,2003), 4.9, 25, "okay"),
     new ConsLog(new Entry(new Date(1,1,2003), 5.1, 26, "good"),
      new MTLog()));
  
  @Test
  void testMiles() {
    assertEquals(this.l1.miles(), 0.0, 0.01);  // to within 1% accuracy
    assertEquals(this.l2.miles(), 5.0, 0.01);
    assertEquals(this.l3.miles(), 8.0, 0.01);
    assertEquals(this.l4.miles(), 34.0, 0.01);
  }
  
  @Test
  void testOneMonth() {
    assertEquals(this.l1.oneMonth(6, 2003), this.l1);
    assertEquals(this.l3.oneMonth(6, 2003), new ConsLog(this.e2,
                                                         new MTLog()));
    assertEquals(this.l4.oneMonth(6, 2003),
                  new ConsLog(this.e3, 
                              new ConsLog(this.e2, new MTLog())));
  }
  
  @Test
  void testSameMonthAndYear() {
    assertEquals(this.d1.sameMonthAndYear(5, 2003), true);
    assertEquals(this.d1.sameMonthAndYear(6, 2003), false);
    assertEquals(this.d1.sameMonthAndYear(5, 2005), false);
    assertEquals(this.d1.sameMonthAndYear(10, 2001), false);
  }
  
  @Test
  void testSortByDist() {
    assertEquals(this.l1.sortByDist(), this.l1);
    assertEquals(this.l2.sortByDist(), this.l2);
    assertEquals(this.l4.sortByDist(), 
                  new ConsLog(this.e2,
                              new ConsLog(this.e1, 
                                          new ConsLog(this.e3, new MTLog()))));
  }
  
  @Test
  void testInsertDist() {
    // in the middle
    assertEquals(
      this.l5.insertByDist(new Entry(new Date(1,3,2003), 5.0, 27, "Great")),
      new ConsLog(new Entry(new Date(1,2,2003), 4.9, 25, "okay"),
       new ConsLog(new Entry(new Date(1,3,2003), 5.0, 27, "Great"),
        new ConsLog(new Entry(new Date(1,1,2003), 5.1, 26, "good"),
         new MTLog()))));
    // at the beginning
    assertEquals(
      this.l5.insertByDist(new Entry(new Date(1,3,2003), 4.8, 27, "Great")),
      new ConsLog(new Entry(new Date(1,3,2003), 4.8, 27, "Great"),
       new ConsLog(new Entry(new Date(1,2,2003), 4.9, 25, "okay"),
        new ConsLog(new Entry(new Date(1,1,2003), 5.1, 26, "good"),
         new MTLog()))));
    // at the end
    assertEquals(
      this.l5.insertByDist(new Entry(new Date(1,3,2003), 5.2, 27, "Great")),
      new ConsLog(new Entry(new Date(1,2,2003), 4.9, 25, "okay"),
       new ConsLog(new Entry(new Date(1,1,2003), 5.1, 26, "good"),
        new ConsLog(new Entry(new Date(1,3,2003), 5.2, 27, "Great"),        
         new MTLog()))));
  }
}