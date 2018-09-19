import java.util.ArrayList;

/* The prime 41, can be written as the sum of six consecutive primes:
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * 
 * This is the longest sum of consecutive primes that adds to a prime
 * below one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds
 * to a prime, contains 21 terms, and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most
 * consecutive primes?
 * */

public class N050ConsecutivePrimeSum2 {

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

	public static boolean[] primesUpTo1M = sieve(1_000_000);

	public static ArrayList<Integer> listPrimes() {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < primesUpTo1M.length; ++i) {
			if (!primesUpTo1M[i]) {
				list.add(i);
			}
		}
		return list;
	}

	public static ArrayList<Integer> primes = listPrimes();
	
	public static ArrayList<Long> sumPrimes() {
		ArrayList<Long> sums = new ArrayList<Long>();
		long sum = 0;
		sums.add(sum);
		for (int i = 0; i < primes.size(); ++i) {
			sum += primes.get(i);
			sums.add(sum);
		}
		return sums;
	}

	public static ArrayList<Long> primeSums = sumPrimes();
	
	public static boolean isPrime(int n) {
		return !primesUpTo1M[n];
	}


	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		int maxRun = 0;
		long maxSum = 0;

		for (int bottom = 0; bottom < primes.size(); ++bottom) {
			for (int runner = bottom + 1; runner < primes.size(); ++runner) {
				long sum = primeSums.get(runner) - primeSums.get(bottom);
				if (sum >= 1_000_000) {
					break;
				}
				if (isPrime((int)sum) && maxRun < runner - bottom) {
					maxRun = runner - bottom;
					maxSum = sum;
				}
			}
		}

		System.out.println("The prime " + maxSum + " is the sum of " + maxRun + " consecutive primes");

		double end = System.currentTimeMillis();
		double length = end - start;
		System.out.println("This took " + length + " ms.");
	}

}
