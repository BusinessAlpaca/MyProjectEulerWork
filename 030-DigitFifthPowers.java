/* Surprisingly there are only three numbers that can be written
 * as the sum of fourth powers of their digits:
 * 
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * 
 * As 1 = 1^4 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * */

public class N030DigitFifthPowers {

	public static boolean isSumOfOwnDigitsRaisedBy(int n, int power) {
		int sum = 0;
		int m = n;
		while (m > 0) {
			sum += Math.pow(m % 10, power);
			m = m / 10;
		}		
		return sum == n;
	}
	
	
	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		int sum = 0;
		int p = 5;
		for (int i = 2; i < 1_000_000; i++) {
			if (isSumOfOwnDigitsRaisedBy(i, p)) {
				System.out.println(i + " is equal to the sum of its digits raised to the power " + p);
				sum += i;
			}
		}
		System.out.println(sum);
		
		double end = System.currentTimeMillis();
		double time = end - start;
		System.out.println("program runtime was " + time + " ms.");
	}

}
