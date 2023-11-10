
import java.util.Objects;

/** Represents 24 hourly temperature readings */
public class DailyRecord {
    private int reading0;
    private int reading1;
    private int reading2;
    private int reading3;
    private int reading4;
    private int reading5;
    private int reading6;
    private int reading7;
    private int reading8;
    private int reading9;
    private int reading10;
    private int reading11;
    private int reading12;   // thank goodness for ChatGPT!!!
    private int reading13;   // Not sure what I would use it for
    private int reading14;   // in coding, besides generating
    private int reading15;   // ridiculous stuff like this
    private int reading16;   
    private int reading17;   // For reference, my prompts
    private int reading18;   // that I used are in a comment 
    private int reading19;   // at the very bottom of this file.
    private int reading20;
    private int reading21;
    private int reading22;
    private int reading23;

    public DailyRecord() {
        // field values initialized to 0 by default in Java
    }

    public DailyRecord(int reading0, int reading1, int reading2, int reading3, int reading4, int reading5, int reading6,
            int reading7, int reading8, int reading9, int reading10, int reading11, int reading12, int reading13,
            int reading14, int reading15, int reading16, int reading17, int reading18, int reading19, int reading20,
            int reading21, int reading22, int reading23) {
        this.reading0 = reading0;
        this.reading1 = reading1;
        this.reading2 = reading2;
        this.reading3 = reading3;
        this.reading4 = reading4;
        this.reading5 = reading5;
        this.reading6 = reading6;
        this.reading7 = reading7;
        this.reading8 = reading8;
        this.reading9 = reading9;
        this.reading10 = reading10;
        this.reading11 = reading11;
        this.reading12 = reading12;
        this.reading13 = reading13;
        this.reading14 = reading14;
        this.reading15 = reading15;
        this.reading16 = reading16;
        this.reading17 = reading17;
        this.reading18 = reading18;
        this.reading19 = reading19;
        this.reading20 = reading20;
        this.reading21 = reading21;
        this.reading22 = reading22;
        this.reading23 = reading23;
    }


    /** 
     *  Records the given temperature value for the given
     *  hour (specified in 24-hour, or "military" time, 0 ... 23).
     */
    public void recordTemp(int hour, int temp) {
        if (hour == 0) {
            reading0 = temp;
        } else if (hour == 1) {
            reading1 = temp;
        } else if (hour == 2) {
            reading2 = temp;
        } else if (hour == 3) {
            reading3 = temp;
        } else if (hour == 4) {
            reading4 = temp;
        } else if (hour == 5) {
            reading5 = temp;
        } else if (hour == 6) {
            reading6 = temp;
        } else if (hour == 7) {
            reading7 = temp;
        } else if (hour == 8) {
            reading8 = temp;
        } else if (hour == 9) {
            reading9 = temp;
        } else if (hour == 10) {
            reading10 = temp;
        } else if (hour == 11) {
            reading11 = temp;
        } else if (hour == 12) {
            reading12 = temp;
        } else if (hour == 13) {
            reading13 = temp;
        } else if (hour == 14) {
            reading14 = temp;
        } else if (hour == 15) {
            reading15 = temp;
        } else if (hour == 16) {
            reading16 = temp;
        } else if (hour == 17) {
            reading17 = temp;
        } else if (hour == 18) {
            reading18 = temp;
        } else if (hour == 19) {
            reading19 = temp;
        } else if (hour == 20) {
            reading20 = temp;
        } else if (hour == 21) {
            reading21 = temp;
        } else if (hour == 22) {
            reading22 = temp;
        } else if (hour == 23) {
            reading23 = temp;
        } else {
            // Handle an invalid hour here, maybe throw an exception or do nothing.
            // This example does nothing for invalid hours.
        }
    }
    

    /**
     * Returns the recorded temperature value for the given hour
     */
    public int getTemp(int hour) {
        if (hour == 0) {
            return reading0;
        } else if (hour == 1) {
            return reading1;
        } else if (hour == 2) {
            return reading2;
        } else if (hour == 3) {
            return reading3;
        } else if (hour == 4) {
            return reading4;
        } else if (hour == 5) {
            return reading5;
        } else if (hour == 6) {
            return reading6;
        } else if (hour == 7) {
            return reading7;
        } else if (hour == 8) {
            return reading8;
        } else if (hour == 9) {
            return reading9;
        } else if (hour == 10) {
            return reading10;
        } else if (hour == 11) {
            return reading11;
        } else if (hour == 12) {
            return reading12;
        } else if (hour == 13) {
            return reading13;
        } else if (hour == 14) {
            return reading14;
        } else if (hour == 15) {
            return reading15;
        } else if (hour == 16) {
            return reading16;
        } else if (hour == 17) {
            return reading17;
        } else if (hour == 18) {
            return reading18;
        } else if (hour == 19) {
            return reading19;
        } else if (hour == 20) {
            return reading20;
        } else if (hour == 21) {
            return reading21;
        } else if (hour == 22) {
            return reading22;
        } else if (hour == 23) {
            return reading23;
        } else {
            // Handle an invalid hour here, maybe throw an exception or return a default value.
            return -1; // Placeholder for an invalid hour
        }
    }

    
    /**
     * Returns the highest recorded temperature value
     */
    public int getHigh() {
        int maxReading = Integer.MIN_VALUE;
        int maxReadingField = -1;

        if (reading0 > maxReading) {
            maxReading = reading0;
            maxReadingField = 0;
        }

        if (reading1 > maxReading) {
            maxReading = reading1;
            maxReadingField = 1;
        }

        if (reading2 > maxReading) {
            maxReading = reading2;
            maxReadingField = 2;
        }

        if (reading3 > maxReading) {
            maxReading = reading3;
            maxReadingField = 3;
        }

        if (reading4 > maxReading) {
            maxReading = reading4;
            maxReadingField = 4;
        }

        if (reading5 > maxReading) {
            maxReading = reading5;
            maxReadingField = 5;
        }

        if (reading6 > maxReading) {
            maxReading = reading6;
            maxReadingField = 6;
        }

        if (reading7 > maxReading) {
            maxReading = reading7;
            maxReadingField = 7;
        }

        if (reading8 > maxReading) {
            maxReading = reading8;
            maxReadingField = 8;
        }

        if (reading9 > maxReading) {
            maxReading = reading9;
            maxReadingField = 9;
        }

        if (reading10 > maxReading) {
            maxReading = reading10;
            maxReadingField = 10;
        }

        if (reading11 > maxReading) {
            maxReading = reading11;
            maxReadingField = 11;
        }

        if (reading12 > maxReading) {
            maxReading = reading12;
            maxReadingField = 12;
        }

        if (reading13 > maxReading) {
            maxReading = reading13;
            maxReadingField = 13;
        }

        if (reading14 > maxReading) {
            maxReading = reading14;
            maxReadingField = 14;
        }

        if (reading15 > maxReading) {
            maxReading = reading15;
            maxReadingField = 15;
        }

        if (reading16 > maxReading) {
            maxReading = reading16;
            maxReadingField = 16;
        }

        if (reading17 > maxReading) {
            maxReading = reading17;
            maxReadingField = 17;
        }

        if (reading18 > maxReading) {
            maxReading = reading18;
            maxReadingField = 18;
        }

        if (reading19 > maxReading) {
            maxReading = reading19;
            maxReadingField = 19;
        }

        if (reading20 > maxReading) {
            maxReading = reading20;
            maxReadingField = 20;
        }

        if (reading21 > maxReading) {
            maxReading = reading21;
            maxReadingField = 21;
        }

        if (reading22 > maxReading) {
            maxReading = reading22;
            maxReadingField = 22;
        }

        if (reading23 > maxReading) {
            maxReading = reading23;
            maxReadingField = 23;
        }

        if (maxReadingField == -1) {
            // Handle the case where all readings are at their default values or uninitialized.
            // You may want to throw an exception or return a specific value in this case.
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


    @Override
    public int hashCode() {
        return Objects.hash(reading0, reading1, reading10, reading11, reading12, reading13, reading14, reading15,
                reading16, reading17, reading18, reading19, reading2, reading20, reading21, reading22, reading23,
                reading3, reading4, reading5, reading6, reading7, reading8, reading9);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DailyRecord other = (DailyRecord) obj;
        return reading0 == other.reading0 && reading1 == other.reading1 && reading10 == other.reading10
                && reading11 == other.reading11 && reading12 == other.reading12 && reading13 == other.reading13
                && reading14 == other.reading14 && reading15 == other.reading15 && reading16 == other.reading16
                && reading17 == other.reading17 && reading18 == other.reading18 && reading19 == other.reading19
                && reading2 == other.reading2 && reading20 == other.reading20 && reading21 == other.reading21
                && reading22 == other.reading22 && reading23 == other.reading23 && reading3 == other.reading3
                && reading4 == other.reading4 && reading5 == other.reading5 && reading6 == other.reading6
                && reading7 == other.reading7 && reading8 == other.reading8 && reading9 == other.reading9;
    }


}



/*

ChatGPT prompts used:


1)
Generate field declarations from 0 to 23:
    private int reading0;


2)
Now, generate an if/else block of statements that uses an int variable, hour, to access the reading value for that hour.


3)
Generate a similar block of statements, but instead of returning the reading for the hour, it should set the reading field to a value, temp.


4)
Add a method to that class that figures out the reading field with the largest value.


5)
Please type out the full method code.


6)
Thank you!

> You're welcome! If you have any more questions or need further assistance, feel free to ask. Happy coding!

*/