/* The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * 
 * Find the last ten digits of the series,
 * 
 * 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 * */

public class N048SelfPowers {
	
	public static long modPow (long base, long exp, long mod) {
		long result = base;
		for (long i = 1; i < exp; ++i) {
			result *= base;
			result = result % mod;
		}
		return result;
	}

	public static void main(String[] args) {
		double start = System.currentTimeMillis();		
		
		long sum = 0;
		for (long i = 1; i < 1001; ++i) {			
			sum += modPow(i, i, 10_000_000_000L);			
		}
		System.out.println(sum % 10_000_000_000L);
		
		double end = System.currentTimeMillis();
		double length = end - start;
		System.out.println("This took " + length + " ms.");
	}

}
