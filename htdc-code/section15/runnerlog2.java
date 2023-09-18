
// Runner's log example (section 15)
// This file adds the "miles()" method to ILog

// represents a runner's log
interface ILog {
  // public ??? ilogMethod(...);

  // to compute the total number of miles recorded in *this* log
  public double miles();
}

// represents an empty runner's log
class MTLog implements ILog {
  MTLog() { }

  /* TEMPLATE:
  public ??? ilogMethod(...) {
    ... this.miles()       -- double
  }
  */

  public double miles() {
    return 0;
  }

}

// represents a runner's log with an entry added to it
class ConsLog implements ILog {
  Entry first;
  ILog rest;

  ConsLog(Entry first, ILog rest) {
    this.first = first;
    this.rest = rest;
  }

  /* TEMPLATE:
  public ??? ilogMethod(...) {
    ... this.first ...     -- Entry
    ... this.rest ...      -- ILog
    
    ... this.miles()       -- double
    
    ... this.first.entryMethod(...) -- ???
    ... this.rest.ilogMethod(...)   -- ???
  }
  */

  public double miles() {
    return this.first.distance  // take distance in the first entry
         + this.rest.miles(); // compute total miles in the *rest* of the log
    
    /* TEMPLATE:
    ... this.first ...     -- Entry
    ... this.rest ...      -- ILog
    
    ... this.first.entryMethod(...) -- ???
    ... this.rest.miles()   -- double  // NOTICE "ilogMethod" ==> "miles"
    */
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

