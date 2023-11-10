

public interface IDailyRecord {
    /** 
     *  Records the given temperature value for the given
     *  hour (specified in 24-hour, or "military" time, 0 ... 23).
     */
    public void recordTemp(int hour, int temp);
    
    /**
     * Returns the recorded temperature value for the given hour
     */
    public int getTemp(int hour);
    
    /**
     * Returns the highest recorded temperature value
     */
    public int getHigh();
    
    /**
     * Returns the lowest recorded temperature value 
     */
    public int getLow();
    
    /**
     * Returns the average temperature
     */
    public int getAverage();
}
