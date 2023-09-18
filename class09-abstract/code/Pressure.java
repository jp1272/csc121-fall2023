
// recording air pressure measurements [in hPa]
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
  public int diffFromHigh() {
    return this.high - this.today;
  }
  
  // produce today's difference from the low of this recording
  public int diffFromLow() {
    return this.today - this.low;
  }
  
  // produce a string description of this recording
  public String asString() {
    return String.valueOf(this.high)
            .concat("-")
            .concat(String.valueOf(this.low))
            .concat("hPa");
  }  
}
