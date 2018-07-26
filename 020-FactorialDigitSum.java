import java.math.BigInteger;

/*n! means n × (n − 1) × ... × 3 × 2 × 1
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!*/

import java.math.BigInteger;

public class N020FactorialDigitSum {

	public static BigInteger factorial(int n) {
		if (n < 2) {
			return BigInteger.ZERO;
		}
		
		if (n == 2) {
			return BigInteger.valueOf(2);
		}
		
		return BigInteger.valueOf(n).multiply(factorial(n-1));
		
	}
	
	public static long sumDigits(BigInteger n) {
		if (n.compareTo(BigInteger.ZERO) == -1) {
			return 0;
		}
			
		if (n.compareTo(BigInteger.TEN) == -1) {
			return n.longValue();
		}
		
		return n.remainder(BigInteger.TEN).longValue() + sumDigits(n.divide(BigInteger.TEN));		
	}
	
	public static void main(String[] args) {
		System.out.println(sumDigits(factorial(100)));
		
	}

}
