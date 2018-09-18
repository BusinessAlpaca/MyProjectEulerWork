/* It was proposed by Christian Goldbach that every odd composite number
 * can be written as the sum of a prime and twice a square.
 * 
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 * 
 * It turns out that the conjecture was false.
 * 
 * What is the smallest odd composite that cannot be written
 * as the sum of a prime and twice a square?
 * */

public class N046GoldbachsOtherConjecture {

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

	public static boolean isSumOfPrimeAndTwiceASquare (int n) {
		for (int i = n - 2; i > 2; i = i - 2) {
			if (!compositesUpTo1B[i]) {
				double check = Math.sqrt((n - i) / 2);
				if (check == (int)check) {
					return true;
				}
			}					
		}
		return false;
	}
	
	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		for (int n = 35; n < 1_000_000_000; n = n + 2) {
			if (compositesUpTo1B[n] && !isSumOfPrimeAndTwiceASquare(n)) {
				System.out.println(n);
				break;
			}
		}
		
		double end = System.currentTimeMillis();
		double length = end - start;
		System.out.println("This took " + length + " ms.");
	}

}
