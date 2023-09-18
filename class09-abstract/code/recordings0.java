
// recordings0.java

// recording air pressure
// measurements [in hPa]
class Pressure {
  int high;
  int today;
  int low;
  
  public Pressure(int high, int today, int low) {
    this.high = high;
    this.today = today;
    this.low = low;
  }
  
  // produce today's difference from the high of this recording
  int diffFromHigh() {
    return this.high - this.today;
  }
  
  // produce today's difference from the low of this recording
  int diffFromLow() {
    return this.today - this.low;
  }
  
  // produce a string description of this recording
  String asString() {
    return String.valueOf(this.high)
            .concat("-")
            .concat(String.valueOf(this.low))
            .concat("hPa");
  }  
}

// recording temperature 
// measurements [in F]
class Temperature {
  int high;
  int today;
  int low;
  
  public Temperature(int high, int today, int low) {
    this.high = high;
    this.today = today;
    this.low = low;
  }
  
  // produce today's difference from the high of this recording
  int diffFromHigh() {
    return this.high - this.today;
  }
  
  // produce today's difference from the low of this recording
  int diffFromLow() {
    return this.today - this.low;
  }
  
  // produce a string description of this recording
  String asString() {
    return String.valueOf(this.high)
            .concat("-")
            .concat(String.valueOf(this.low))
            .concat("F");
  }  
}