/* The first two consecutive numbers to have two distinct prime factors are:
 * 14 = 2 × 7
 * 15 = 3 × 5
 * 
 * The first three consecutive numbers to have three distinct prime factors are:
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 * 
 * Find the first four consecutive integers to have four distinct prime factors each.
 * What is the first of these numbers?
 * */

public class N047DistinctPrimeFactors {

	public static boolean[] sieve(int n) {
		boolean[] sieve = new boolean[n + 1];
		sieve[0] = true;
		sieve[1] = true;
		for (int i = 4; i <= sieve.length - 1; i = i + 2) {
			sieve[i] = true;
		}
		for (int i = 3; i <= (int) Math.sqrt(n); i = i + 2) {
			if (!sieve[i]) {
				for (int j = i * i; j <= sieve.length - 1; j = j + 2 * i) {
					sieve[j] = true;
				}
			}
		}
		return sieve;
	}

	public static boolean[] compositesUpTo1B = sieve(1_000_000_000);

	public static boolean has4DistinctPrimeFactors (int n) {
		if (!compositesUpTo1B[n]) return false;
		int count = 0;
		if (n % 2 == 0) {
			++count;
			while (n % 2 == 0) {
				n = n / 2;
			}
		}		
		for (int i = 3; i <= n; i = i + 2) {
			if (!compositesUpTo1B[i] && n % i == 0) {
				++count;
				if (count > 4) {
					return false;
				}
				while (n % i == 0) {
					n = n / i;
				}
			}
		}
		return count == 4;
	}
	
	public static void main(String[] args) {
		double start = System.currentTimeMillis();		
		
		int i = 4;
		while (i < 1_000_000_000) {
			if (!has4DistinctPrimeFactors(i)) {
				++i;
				continue;
			}
			if (!has4DistinctPrimeFactors(i + 1)) {
				i = i + 2;
				continue;
			}
			if (!has4DistinctPrimeFactors(i + 2)) {
				i = i + 3;
				continue;
			}
			if (!has4DistinctPrimeFactors(i + 3)) {
				i = i + 4;
				continue;
			}
			System.out.println(i);
			break;
		}			
		
		double end = System.currentTimeMillis();
		double length = end - start;
		System.out.println("This took " + length + " ms.");
	}

}
