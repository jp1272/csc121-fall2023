import java.util.Arrays;

public class Primes {

    public static void main(String[] args) {
        int limit = 100;
        int runs = 10;
        
        if (args.length >= 2) { limit = Integer.parseInt(args[0]); runs = Integer.parseInt(args[1]); }

        PrimeComputer pc = new PrimeComputer();
        int[] primes = null;
        
        long sumTime = 0;
        for (int i = 0; i < runs; i++) {    
            long start = System.nanoTime();
            primes = pc.computeTo(limit);
            long elapsed = System.nanoTime() - start;
            sumTime += elapsed;
        }
        
        System.out.println("Time: " + (sumTime/runs));
        System.out.println(primes.length);
        System.out.println(Arrays.toString(primes));        // *** COMMENT OUT if limit is large
    }
    
}


/*


    N           time            primes.length
    
10000000        1832830254      664579



 */

