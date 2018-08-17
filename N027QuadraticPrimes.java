/*    Euler discovered the remarkable quadratic formula:
 *    n^2 + n + 41
 *    It turns out that the formula will produce 40 primes for the consecutive integer 
 *    values 0 ≤ n ≤ 39. However, when n = 40,
 *    40^2 + 40 + 41 = 40 (40 + 1) + 41 is divisible by 41, and certainly when n = 41,
 *    41^2 + 41 + 41 is clearly divisible by 41.
 *    
 *    The incredible formula:
 *    n^2 − 79n + 1601 was discovered, which produces 80 primes for the consecutive
 *    values 0 ≤ n ≤ 79. The product of the coefficients, −79 and 1601, is −126479.
 *    
 *    Considering quadratics of the form:
 *    
 *    n^2 + an + b, where |a| < 1000 and |b| ≤ 1000
 *    
 *    Find the product of the coefficients, a and b, for the quadratic expression that
 *    produces the maximum number of primes for consecutive values of n, starting with n=0.
 * */



/* some insights:
 *    - b must be prime (and therefore positive), otherwise 0^2 + 0 + b would be divisible.
 *    - the quadratic cannot return more than b + 1 consecutive primes, because
 *      b^2 + ab + b is divisible by b and so not prime.
 *    - since a < 1000, the largest possible prime a quadratic can return is
 *      smaller than 1000^2 + 999^1000 + 1000 = 2000000 
 * */

public class N027QuadraticPrimes {
	
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
	
	public static boolean[] primesUpTo2M = sieve(2000000);
	
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}		
		if (primesUpTo2M[n]) {
			return false;
		}
		return true;
	}

	public static int countConsecPrimes (int a, int b) {		
		int n = 0;
		while (isPrime((a + n) * n + b)) {
			++n;
		}
		return n;
	}

	
	public static void main(String[] args) {
		int coefA = 0;
		int coefB = 0;
		int coefC = 0;
		for (int a = -999; a < 1000; ++a) {
			for (int b = 0; b < 1001; ++b) {
				if (isPrime(b)) {
					int c = countConsecPrimes(a, b);
					if (c > coefC) {
						coefA = a;
						coefB = b;
						coefC = c;
					}					
				}
			}
		}
		int prod = coefA * coefB; 
		System.out.println("a = " + coefA);
		System.out.println("b = " + coefB);
		System.out.println("number of conseqcutive primes = " + coefC);
		System.out.println("a*b = " + prod);
	}

}
