
// Runner's log example (section 15)
// This is the complete version with all developments from section 15
// Note: the sort by distance is in increasing amount of distance
//   i.e. from shortest run to longest


// represents a runner's log

import java.util.Objects;

interface ILog {
  // public ??? ilogMethod(...);

  // to compute the total number of miles recorded in *this* log
  public double miles();
  
  // to extract those entries in *this* log for the given month and year
  public ILog oneMonth(int month, int year);
  
  // produce a sorted version of *this* log, with entries sorted by distance
  public ILog sortByDist();
  
  // insert the given entry into *this* (sorted) log
  public ILog insertByDist(Entry e);
}


// represents an empty runner's log
class MTLog implements ILog {
  MTLog() { }

  /* TEMPLATE:
  public ??? ilogMethod(...) {
    ... this.miles()       -- double
  }
  */

  // to compute the total number of miles recorded in *this* log
  public double miles() {
    return 0;
  }

  // to extract those entries in *this* log for the given month and year
  public ILog oneMonth(int month, int year) {
    return new MTLog();
  }

  // produce a sorted version of *this* log, with entries sorted by distance
  public ILog sortByDist() {
    return this;
  }

  // insert the given entry into *this* (sorted) log
  public ILog insertByDist(Entry e) {
    return new ConsLog(e, this);
  }


  @Override
  public boolean equals(Object other) {
      return other instanceof MTLog;
  }

  @Override
  public int hashCode() {
      return MTLog.class.hashCode();
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

// to compute the total number of miles recorded in *this* log
  public double miles() {
    return this.first.distance  // take distance in the first entry
         + this.rest.miles(); // compute total miles in the *rest* of the log
  }

  // to extract those entries in *this* log for the given month and year
  public ILog oneMonth(int month, int year) {
    if (this.first.sameMonthAndYear(month, year)) {
      return 
        new ConsLog(this.first,
                    this.rest.oneMonth(month, year));
    } else {
      return this.rest.oneMonth(month, year);
    }
  }
  
  // produce a sorted version of *this* log, with entries sorted by distance
  public ILog sortByDist() {
    return this.rest.sortByDist().insertByDist(this.first);
  }

  // insert the given entry into *this* (sorted) log
  public ILog insertByDist(Entry e) {
    if (e.distance < this.first.distance) {
      return new ConsLog(e, this);
    } else {
      return new ConsLog(this.first,
                         this.rest.insertByDist(e));
    }
  }
  
  @Override
  public int hashCode() {
      return Objects.hash(first, rest);
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj)
          return true;
      if (obj == null)
          return false;
      if (getClass() != obj.getClass())
          return false;
      ConsLog other = (ConsLog) obj;
      return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
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
  
  // does *this* entry match the given month and year
  boolean sameMonthAndYear(int month, int year) {
    return this.d.sameMonthAndYear(month, year);
  }

  @Override
  public int hashCode() {
      return Objects.hash(comment, d, distance, duration);
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj)
          return true;
      if (obj == null)
          return false;
      if (getClass() != obj.getClass())
          return false;
      Entry other = (Entry) obj;
      return Objects.equals(comment, other.comment) && Objects.equals(d, other.d)
              && Double.doubleToLongBits(distance) == Double.doubleToLongBits(other.distance)
              && duration == other.duration;
  }

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
  
  // is *this* date in the given month and year
  boolean sameMonthAndYear(int month, int year) {
    return (this.month == month && this.year == year);
  }

  @Override
  public int hashCode() {
      return Objects.hash(day, month, year);
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj)
          return true;
      if (obj == null)
          return false;
      if (getClass() != obj.getClass())
          return false;
      Date other = (Date) obj;
      return day == other.day && month == other.month && year == other.year;
  }

}

