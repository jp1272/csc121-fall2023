
/** Represents 24 hourly temperature readings */
public class DailyRecord {
	
	int[] reading;
    
    public DailyRecord() {
    	this.reading = new int[24];
    	
        int i = 0;
        
        while ( i < 24 ) {
        	this.reading[i] = Integer.MIN_VALUE;
        	i = i + 1;
        }
    	
    }
    
    /** 
     *  Records the given temperature value for the given
     *  hour (specified in 24-hour, or "military" time, 0 ... 23).
     */
    public void recordTemp(int hour, int temp) {
        this.reading[hour] = temp;
        return;
    }
    
    /**
     * Returns the recorded temperature value for the given hour
     */
    public int getTemp(int hour) {
        return this.reading[hour];
    }
    
    /**
     * Returns the highest recorded temperature value
     */
    public int getHigh() {
        int maxReading = Integer.MIN_VALUE;
        int maxReadingHour = -1;

        int i = 0;
        
        while ( i < 24 ) {
	        if (reading[i] > maxReading) {
	            maxReading = reading[i];
	            maxReadingHour = i;
	        }
	        i = i + 1;
        }
        
        if (maxReadingHour < 0) {
        	throw new IllegalStateException("No readings have been set.");
        }
        
        return maxReading;

    }
    
    /**
     * Returns the lowest recorded temperature value 
     */
    public int getLow() {
        // TODO: stub
        return 0;
    }
    
    /**
     * Returns the average temperature
     */
    public int getAverage() {
        // TODO: stub 
        return 0;
    }

    
    
    // auto-generated methods
    
    
    

}

