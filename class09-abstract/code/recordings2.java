

// recordings2.java

// commonalities in weather recordings
class Recording {
  int high;
  int today;
  int low;
  String unit;

  Recording(int high, int today, int low, String unit) {
    this.high = high;
    this.today = today;
    this.low = low;
    this.unit = unit;
  }

  int diffFromHigh() {
    return this.high - this.today;
  }

  int diffFromLow() {
    return this.today - this.low;
  }

  String asString() {
    return String.valueOf(this.high).concat("-")
            .concat(String.valueOf(this.low))
            .concat(this.unit);
  }  
}

// recording air pressure
// measurements [in hPa]
class Pressure extends Recording {
  public Pressure(int high, int today, int low) {
    super(high, today, low, "hPa");
  }
}

// recording temperature 
// measurements [in F]
class Temperature extends Recording {
  Temperature(int high, int today, int low) {
    super(high, today, low, "F");
  }  
}
