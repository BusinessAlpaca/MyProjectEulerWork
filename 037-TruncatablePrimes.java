/*The number 3797 has an interesting property.
 * Being prime itself, it is possible to continuously remove
 * digits from left to right, and remain prime at each stage:
 * 
 * 3797, 797, 97, and 7.
 * 
 * Similarly we can work from right to left:
 * 
 * 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * */

public class N037TruncatablePrimes {
	
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
	
	public static boolean isTruncatablePrime(int n) {
		int left = n, right = n;
		while (left > 0) {
			if (!isPrime(left)) {
				return false;
			}
			left = left / 10;
		}
		while (right > 0) {
			if (!isPrime(right)) {
				return false;
			}
			right = right % (int)(Math.pow(10, Integer.toString(right).length() - 1));
		}
		return true;
	}

	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		int count = 0, sum = 0;
		for (int n = 10; n < 1_000_000; ++n) {
			if (isTruncatablePrime(n)) {
				++count;
				sum += n;
			}
		}
		System.out.println("Count is " + count + ". And sum is " + sum + ".");
		
		double end = System.currentTimeMillis();
		double time = end - start;
		System.out.println("program runtime was " + time + " ms.");
	}
}
