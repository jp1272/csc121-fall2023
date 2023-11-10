
/** 
 * Represents a list of numbers 
 */
public interface ILoN {
    /** 
     * Produces an updated list with the n'th value 
     * of this list to `v`. (Extends the list if necessary
     * to get to the n'th value.)
     */
    ILoN setValue(int n, int v);

    
    /**
     * Returns the number in the n'th item of this list
     */
    int getValue(int n);
}


