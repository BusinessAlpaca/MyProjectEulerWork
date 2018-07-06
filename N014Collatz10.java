
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

	public static int nextCollatzNumber(int n) {
		if (n % 2 == 0)
			return n / 2;
		return 3 * n + 1;
	}
	
	public static int lengthOfCollatzSequence(int n) {		
		int l = 1;
		while (n != 1) {
			n = nextCollatzNumber(n);
			l++;
		}
		return l;		
	}
	
	public static int optimisedLengthOfCollatzSequence(int n, int[] lengths) {
		if (n == 1) {return 1;}
		if (n < lengths.length - 1 && lengths[n] != 0) {return lengths[n];}
		if (n < lengths.length - 1) {lengths[n] = lengthOfCollatzSequence(n);}
		return lengthOfCollatzSequence(n);
	}
	
	public static void main(String[] args) {
		int[] lengths = new int[20000000];
		int longest = 0;		
		int size = 0;
		int big = 0;
		for (int i = 1; i < 1000000; i++) {
			size = optimisedLengthOfCollatzSequence(i, lengths);
			if (size > longest) {
				longest = size;
				big = i;
			}
		}
		System.out.println(big);
	}

}
