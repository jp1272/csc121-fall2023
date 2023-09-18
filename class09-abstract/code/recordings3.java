
// recordings3.java

// commonalities in weather recordings
abstract class ARecording {
  int high;
  int today;
  int low;
  
  ARecording(int high, int today, int low) {
    this.high = high;
    this.today = today;
    this.low = low;
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
            .concat(this.unit());
  }  
  
  // FORCE SUBCLASSES TO IMPLEMENT THIS:
  abstract String unit();  
  // (can't force subclasses to define a field,
  //  but can force them to define a method like
  //  this)
}


// recording air pressure
// measurements [in hPa]
class Pressure extends ARecording {
  public Pressure(int high, int today, int low) {
    super(high, today, low);
  }
  
  String unit() { return "hPa"; }
}


// recording temperature 
// measurements [in F]
class Temperature extends ARecording {
  Temperature(int high, int today, int low) {
    super(high, today, low);
  }  
  
  String unit() { return "F"; }
}
