import java.util.Arrays;
import java.util.ArrayList;

/* The arithmetic sequence, 1487, 4817, 8147,
 * in which each of the terms increases by 3330, is unusual in two ways:
 * 
 * (i) each of the three terms are prime, and,
 * (ii) each of the 4-digit numbers are permutations of one another.
 * 
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 * 
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 * */

public class N049PrimePermutations {

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

	public static boolean[] primesUpTo10K = sieve(10_000);

	public static boolean isPrime(int n) {
		return !primesUpTo10K[n];
	}

	public static String getNextPermutation(String str) {

		char[] ar = str.toCharArray();

		int descendingSuffixStartIndex = ar.length - 1;
		for (int i = ar.length - 1; i >= 1; i--) {
			if (ar[i - 1] >= ar[i]) {
				descendingSuffixStartIndex--;
			} else {
				break;
			}
		}

		if (descendingSuffixStartIndex == 0) {
			return null;
		}

		int lastCharBiggerThanSuffixAdjacentIndex = descendingSuffixStartIndex;
		for (int i = ar.length - 1; i >= descendingSuffixStartIndex; i--) {
			if (ar[i] > ar[descendingSuffixStartIndex - 1]) {
				lastCharBiggerThanSuffixAdjacentIndex = i;
				break;
			}
		}

		char temp = ar[descendingSuffixStartIndex - 1];
		ar[descendingSuffixStartIndex - 1] = ar[lastCharBiggerThanSuffixAdjacentIndex];
		ar[lastCharBiggerThanSuffixAdjacentIndex] = temp;

		int top = descendingSuffixStartIndex;
		int bottom = ar.length - 1;
		while (top < bottom) {
			char temp2 = ar[top];
			ar[top] = ar[bottom];
			ar[bottom] = temp2;
			top++;
			bottom--;
		}

		String next = new String(ar);
		return next;
	}

	public static boolean sameDigits(String str1, String str2) {
		char[] first = str1.toCharArray();
		char[] second = str2.toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);
		return Arrays.equals(first, second);
	}

	public static void main(String[] args) {
		double start = System.currentTimeMillis();

		for (int i = 1001; i < 10_000; i = i + 2) {
			if (isPrime(i)) {
				String nextS = getNextPermutation(Integer.toString(i));
				while (nextS != null) {
					int next = Integer.parseInt(nextS);
					if (isPrime(next)) {
						int third = next + (next - i);
						if (third < 10_000 && isPrime(third) && sameDigits(nextS, Integer.toString(third))) {
							System.out.println("" + i + next + third);
						}
					}
					nextS = getNextPermutation(nextS);
				}				
			}
		}

		double end = System.currentTimeMillis();
		double length = end - start;
		System.out.println("This took " + length + " ms.");
	}

}
