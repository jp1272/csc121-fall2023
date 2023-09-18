
// Runner's log example (section 15)
// This file is the class definitions and examples only 
// (without templates for the ILog union classes)

// represents a runner's log (as a list of entries)
interface ILog {
}

// represents an empty runner's log
class MTLog implements ILog {
  MTLog() {}
}

// represents a runner's log with an entry added to it
class ConsLog implements ILog {
  Entry first;
  ILog rest;

  ConsLog(Entry first, ILog rest) {
    this.first = first;
    this.rest = rest;
  }
}

// represents an entry in a runner's log
class Entry {
  Date d;
  double distance;  // miles
  int duration;     // minutes
  String comment;

  Entry(Date d, double distance, int duration, String comment) {
    this.d = d;
    this.distance = distance;
    this.duration = duration;
    this.comment = comment;
  }

  /* TEMPLATE:
  public ??? entryMethod(...) {
    ... this.d ...           -- Date
    ... this.distance ...    -- double
    ... this.duration ...    -- int
    ... this.comment ...     -- String
    
    ... this.d.dateMethod(...) -- ???
  }
  */
}


// represents a calendar date
class Date {
  int day;
  int month;
  int year;

  Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /* TEMPLATE:
  public ??? dateMethod(...) {
    ... this.day ...      -- int
    ... this.month ...    -- int
    ... this.year ...     -- int
  }
  */
}


class LogExamples {
  LogExamples() {}
  
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
}