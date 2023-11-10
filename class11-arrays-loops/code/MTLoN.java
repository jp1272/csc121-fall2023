
/**
 * Represents an empty list of numbers
 */
public class MTLoN implements ILoN {
    
    public MTLoN() { }

    @Override
    public ILoN setValue(int n, int v) {
        // TODO : fill this in
        return this;
    }

    @Override
    public int getValue(int n) {
        throw new IllegalStateException("index out of bounds: " + n);
    }
    
    
    // auto-generated methods
    
    @Override
    public boolean equals(Object other) {
        return other instanceof MTLoN;
    }

    @Override
    public int hashCode() {
        return MTLoN.class.hashCode();
    }

    @Override
    public String toString() {
        return "MTLoN []";
    }

}
