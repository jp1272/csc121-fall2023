
// TODO: fill in the three methods (do `isPrime` first - has its own tests)

public class PrimeComputer {
    
    private boolean[] prime;    // prime[n] is whether n is prime
    private int[] primes;       // primes is the array of prime numbers
    private int primesFound;    // the number of primes found 
    
    
    public PrimeComputer() {
        this.primes = null;
    }
    
    
    /**
     * compute and returns prime numbers from 2...limit (inclusive)
     */
    public int[] computeTo(int limit) {
        this.prime = new boolean[limit+1];  // [0]..[limit],  ignore indices [0] and [1]
        this.primesFound = 0;

        checkRange(2, limit);
        enumeratePrimes();

        return this.primes;
    }
    
    
    /**
     * checks and fills in prime[start] ... prime[end] (inclusive) elements with whether
     * they are prime or not. Increments primesFound every time one is found.
     */
    public void checkRange(int start, int end) {  
        // TODO
    }
    
    
    /**
     * Fills in the `primes` array with all numbers `p` >= 2 such that `prime[p]` is true.
     * The number of such numbers should be `primesFound`. Construct the `primes`
     * array accordingly.
     */
    public void enumeratePrimes() {
        // TODO
    }
    

    /**
     * Checks if n is prime, by checking the remainder when divided 
     * by all numbers  2 <= i <= sqrt(n)
     */
    public boolean isPrime(int n) {        
        // TODO
    
        return false;
    }

}
