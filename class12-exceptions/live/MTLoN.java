
/**
 * Represents an empty list of numbers
 */
public class MTLoN implements ILoN {
    
    public MTLoN() { }

    @Override
    public ILoN setValue(int n, int v) {
    	if (n == 0)
    		return new ConsLoN(v, new MTLoN());
    	else
    		return new ConsLoN(0, this.setValue(n-1,v));
    }

    @Override
    public int getValue(int n) throws ListOperationException {
        throw new ListOperationException(n);
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