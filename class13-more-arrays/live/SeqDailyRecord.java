

/**
 * Records hourly temperatures in sequential order, i.e.
 * you cannot record a temperature for hour h until readings for
 * hours 0...(h-1) have been recorded.
 
 * If hours 0...(h-1) have been recorded, you can *rerecord* a temperature
 * for any hour h' < h.
 * 
 */
public class SeqDailyRecord implements IDailyRecord {

	private int[] readings;
	private int count;  // number of actually filled in values
						// in `this.readings`
	
	public SeqDailyRecord() {
		this.readings = new int[24];
	}

	@Override
	public void recordTemp(int hour, int temp) {
		if (hour <= this.count) {
			this.readings[hour] = temp;
			this.count = this.count + 1;
		} else {
			throw new IllegalArgumentException("invalid hour " + hour);
		}
	}

	@Override
	public int getTemp(int hour) {
		if (hour < this.count) {
			return this.readings[hour];
		} else {
			throw new IllegalArgumentException("invalid hour " + hour);			
		}
	}

	@Override
	public int getHigh() {
		if (this.count <= 0) {
			throw new IllegalStateException("no readings recorded");	
		} 
		
		int max = this.readings[0];  // accumulates the highest value
		int i = 1;  // index into the array
		
		while ( i < this.count ) {
			if (this.readings[i] > max) {
				max = this.readings[i];
			}
		}
		
		return max;
	}

	@Override
	public int getLow() {
		throw new IllegalStateException("no readings recorded");			
		//return 0;
	}

	@Override
	public int getAverage() {
		throw new IllegalStateException("no readings recorded");			
		//return 0;
	}
	
}
