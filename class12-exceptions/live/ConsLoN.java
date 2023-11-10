import java.util.Objects;

/**
 * Represents a number added to an existing list
 */
class ConsLoN implements ILoN {
    private int first;
    private ILoN rest;
    
    public ConsLoN(int first, ILoN rest) {
        this.first = first;
        this.rest = rest;
    }
    
    @Override
    public ILoN setValue(int n, int v) {
    	if (n == 0)
    		this.first = v;
    	else 
    		this.rest = this.rest.setValue(n-1, v);
    	return this;
    }
    
    @Override
    public int getValue(int n) throws ListOperationException {
    	if (n != 0) {
    		try {
    			return this.rest.getValue(n-1);
    		} catch (ListOperationException exc) {
    			throw new ListOperationException(n);
    		}
    	} else {
    		return this.first;
    	}
    }


    
    // auto-generated methods

    @Override
    public int hashCode() {
        return Objects.hash(first, rest);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConsLoN other = (ConsLoN) obj;
        return first == other.first && Objects.equals(rest, other.rest);
    }

    @Override
    public String toString() {
        return "ConsLoN [first=" + first + ", rest=" + rest + "]";
    }


}