/* 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * 
 * Find the sum of all numbers which are equal to the sum of the
 * factorial of their digits.
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * */

public class N034DigitFactorials {	
	
	public static boolean isSumOfFactorialOfDigits (int n) {
		int[] factorials = {1, 1, 2, 6, 24,
				120, 720, 5040, 40320, 362880};
		int num = n;
		int sum = 0;
		
		while (num > 0) {
			sum += factorials[num % 10];
			num /= 10;
		}
		
		return sum == n;
	}

	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		int sum = 0;
		for (int n = 10; n < 1_000_000; ++n) {
			if (isSumOfFactorialOfDigits(n)) {
				System.out.println(n);
				sum += n;
			}
		}
		System.out.println(sum);
		
		double end = System.currentTimeMillis();
		double time = end - start;
		System.out.println("program runtime was " + time + " ms.");
	}
}
