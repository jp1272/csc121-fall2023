
// recording air pressure measurements [in hPa]
class Pressure extends Recording {
  
  public Pressure(int high, int today, int low) {
    super(high, today, low);
  }

  public String units() {
		return "hPa";
	}
}
