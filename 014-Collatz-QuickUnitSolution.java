
/* The following iterative sequence is defined for the set of positive integers:
 * 
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 13 - 40 - 20 - 10 - 5 - 16 - 8 - 4 - 2 - 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 */

public class N014Collatz10 {

	public static long nextCollatzNumber(long n) {
		if (n % 2 == 0)
			return n / 2;
		return 3 * n + 1;
	}

	public static int optimisedLengthOfCollatzSequence(long n, int[] lengths) {
		int m = 0;
		if (n == 1) {
			return 1;
		}
		if (n < lengths.length - 1 && lengths[Math.toIntExact(n)] != 0) {
			return lengths[Math.toIntExact(n)];
		}
		m = optimisedLengthOfCollatzSequence(nextCollatzNumber(n), lengths) + 1;
		if (n < lengths.length - 1) {			
			lengths[Math.toIntExact(n)] = m;
		}
		return m;
	}

	public static void main(String[] args) {
		int[] lengths = new int[20000000];
		int longest = 0;
		int big = 0;
		for (int i = 1; i < 1000000; i++) {
			int size = optimisedLengthOfCollatzSequence(i, lengths);
			if (size > longest) {
				longest = size;
				big = i;
			}
		}
		System.out.println(big);
	}

}
