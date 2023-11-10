
// recording temperature measurements [in F]
class Temperature extends Recording {

	public Temperature(int high, int today, int low) {
		super(high, today, low);
	}

	public String units() {
		return "F";
	}
}
