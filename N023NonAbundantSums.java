/*A perfect number is a number for which the sum of its proper divisors is exactly equal
 * to the number.
 * 
 * For example, the sum of the proper divisors of 28 would be
 * 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than n and
 * it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number
 * that can be written as the sum of two abundant numbers is 24.
 * 
 * By mathematical analysis, it can be shown that all integers greater than 28123 can
 * be written as the sum of two abundant numbers. However, this upper limit cannot be
 * reduced any further by analysis even though it is known that the greatest number
 * that cannot be expressed as the sum of two abundant numbers is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum of two
 * abundant numbers.
 * */

public class N023NonAbundantSums {

	public static int sumProperDivisors(int n) {
		if (n <= 1)
			return 0;

		int searchMax = (int) Math.sqrt(n);
		int sum = 0;

		if (searchMax * searchMax == n) {
			sum = 1 + searchMax;
			searchMax = searchMax - 1;
		} else {
			sum = 1;
		}

		for (int i = 2; i <= searchMax; i++) {
			if (n % i == 0) {
				sum += i;
				sum += n / i;
			}
		}

		return sum;
	}

	public static boolean[] listAbundantsUpTo(int n) {
		boolean[] list = new boolean[n + 1];
		for (int i = 1; i < list.length; i++) {
			if (i < sumProperDivisors(i)) {
				list[i] = true;
			}
		}
		return list;
	}

	public static boolean isSumOfTwoAbundants(int n, boolean[] listOfAbundants) {
		for (int i = 1; i < n; i++) {
			if (listOfAbundants[i] && listOfAbundants[n - i]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int sumOfNonSumsOfTwoAbundants = 0;
		boolean[] listOfAbundants = listAbundantsUpTo(28123);
		for (int n = 1; n < 28124; n++) {
			if (!isSumOfTwoAbundants(n, listOfAbundants)) {
				sumOfNonSumsOfTwoAbundants += n;
			}
		}
		System.out.println(sumOfNonSumsOfTwoAbundants);
	}
}
