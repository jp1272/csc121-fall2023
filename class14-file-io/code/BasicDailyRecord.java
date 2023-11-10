
import java.util.Arrays;

/** Represents 24 hourly temperature readings */
public class BasicDailyRecord implements IDailyRecord {
    private int[] readings;
    
    public BasicDailyRecord() {
        this.readings = new int[24];
        
        int i = 0; 
        while ( i < 24 ) {
            this.readings[i] = Integer.MIN_VALUE;
            i = i + 1;
        }
    }
    
    // package access only
    BasicDailyRecord(int[] readings) {
        this.readings = readings;
    }
    
    /** 
     *  Records the given temperature value for the given
     *  hour (specified in 24-hour, or "military" time, 0 ... 23).
     */
    public void recordTemp(int hour, int temp) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("invalid hour " + hour);
        }
        this.readings[hour] = temp;
    }
    
    /**
     * Returns the recorded temperature value for the given hour
     */
    public int getTemp(int hour) {
        if (this.readings[hour] == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No reading for hour " + hour);
        }
        return this.readings[hour];
    }
    
    
    /**
     * Returns true if there is a temperature
     * recorded for the given hour
     */
    public boolean hasTemp(int hour) {
    	return this.readings[hour] >= -460;
    }
    
    
    /**
     * Returns the highest recorded temperature value
     */
    public int getHigh() {
        int maxReading = Integer.MIN_VALUE;
        int maxReadingHour = -1;

        int i = 0;
        
        while ( i < this.readings.length ) {
            if (this.readings[i] > maxReading) {
                maxReading = this.readings[i];
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
        int minReading = Integer.MAX_VALUE;
        int minReadingHour = -1;
        
        int i = 0;
        
        while ( i < 24 ) {
            if (this.readings[i] != Integer.MIN_VALUE) {
                if (this.readings[i] < minReading) {
                    minReading = this.readings[i];
                    minReadingHour = i;
                }
            }
            i = i + 1;
        }
        
        if (minReadingHour < 0) {
            throw new IllegalStateException("No readings have been set.");
        }
        
        return minReading;
    }
    
    /**
     * Returns the average temperature
     */
    public int getAverage() {
        int sum =  0;
        int count = 0;
        int i = 0;
        
        while ( i < 24 ) {
            if (this.readings[i] != Integer.MIN_VALUE) {
                sum = sum + this.readings[i];
                count = count + 1;
            }
            i = i + 1;
        }
        
        if (count == 0) {
            throw new IllegalStateException("No readings have been set.");
        }
        
        return (sum / count);
    }

    
    
    // auto-generated methods
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(readings);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BasicDailyRecord other = (BasicDailyRecord) obj;
        return Arrays.equals(readings, other.readings);
    }

}


