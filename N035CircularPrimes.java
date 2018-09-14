/* The number, 197, is called a circular prime because all rotations
 * of the digits: 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100:
 * 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 * */

public class N035CircularPrimes {

	public static boolean[] sieve(int n) {
		boolean[] sieve = new boolean[n+1];
		sieve[0] = true;
		sieve[1] = true;
		for (int i = 4; i <= sieve.length - 1; i = i +2) {
			sieve[i] = true;
		}
		for (int i = 3; i <= (int)Math.sqrt(n); i = i +2) {
			if (!sieve[i]) {
				for (int j = i*i; j <= sieve.length - 1; j = j + 2*i) {
					sieve[j] = true;
				}
			}
		}
		return sieve;
	}
	
	public static boolean[] primesUpTo1M = sieve(1_000_000);
	
	public static boolean isPrime(int n) {		
		return !primesUpTo1M[n];		
	}
	
	public static boolean isCircularPrime (int n) {
		int digitCount = Integer.toString(n).length();
		int rotationCount = digitCount;		
		while (rotationCount > 0) {
			if (!isPrime(n)) {
				return false;
			}
			int lastDig = n % 10;
			n = n / 10;					
			n = (lastDig * (int)(Math.pow(10, digitCount - 1))) + n;			
			--rotationCount;
		}
		return true;
	}
	
	public static void main(String[] args) {		
		double start = System.currentTimeMillis();
		
		int countCircularPrimes = 0;
		for (int n = 1; n < 1_000_000; ++n) {
			if (isCircularPrime(n)) {				
				++countCircularPrimes;
			}
		}
		System.out.println(countCircularPrimes);
		
		double end = System.currentTimeMillis();
		double time = end - start;
		System.out.println("program runtime was " + time + " ms.");

	}

}
