//The following iterative sequence is defined for the set of positive integers:
//n -> n/2 (n is even)
//n -> 3n + 1 (n is odd)
//Using the rule above and starting with 13, we generate the following sequence:
//13 - 40 - 20 - 10 - 5 - 16 - 8 - 4 - 2 - 1
//It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
//Although it has not been proved yet it is thought that all starting numbers finish at 1.
//Which starting number, under one million, produces the longest chain?

public class N014Collatz {

	public static int collatzL(long n) {		
		int l = 1;
		while (n != 1) {
			if (n%2 == 0) {
				n = n/2;				
			} else {
				n = 3*n + 1;
			}
		l++;
		}
		return l;
	}
		
	public static void main(String[] args) {
		long limit = 1000000; // Limit is one million
		int size = 0;
		int max = 1;
		long j = 0;
		for (long i = 2; i < limit; i++) {
			size = collatzL(i);
			if (size > max) {
				max = size;
				j = i;
			}
		}
		System.out.println("Starting number, under one million, produces the longest chain is : " + j);
	
	}

}
