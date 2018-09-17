/* We shall say that an n-digit number is pandigital if it makes use of
 * all the digits 1 to n exactly once. For example, 2143 is a 4-digit
 * pandigital and is also prime.
 * 
 * What is the largest n-digit pandigital prime that exists?
 * */

public class N041PandigitalPrime {	
	
	public static String decreasePermutation(String str) {
		
		char[] ar = str.toCharArray();
		
		int ascendingSuffixStartIndex = ar.length - 1;
		for (int i = ar.length - 1; i >= 1; i--) {
			if (ar[i - 1] <= ar[i]) {
				ascendingSuffixStartIndex--;
			} else {
				break;
			}
		}
		
		if (ascendingSuffixStartIndex == 0) {
			switch (ar.length) {
			case 9: return "87654321";
			case 8: return "7654321";
			case 7: return "654321";
			case 6: return "54321";
			case 5: return "4321";
			case 4: return "321";
			case 3: return "21";
			case 2: return "1";
			default: return null;
			}
		}
		
		int lastCharSmallerThanSuffixAdjacentIndex = ascendingSuffixStartIndex;
		for (int i = ar.length - 1; i >= ascendingSuffixStartIndex; i--) {
			if (ar[i] < ar[ascendingSuffixStartIndex - 1]) {
				lastCharSmallerThanSuffixAdjacentIndex = i;
				break;
			}
		}
		
		 char temp = ar[ascendingSuffixStartIndex - 1];
		 ar[ascendingSuffixStartIndex - 1] = ar[lastCharSmallerThanSuffixAdjacentIndex];
		 ar[lastCharSmallerThanSuffixAdjacentIndex] = temp;
		 
		 int top = ascendingSuffixStartIndex;
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
	
	public static boolean[] primesUpTo1B = sieve(1_000_000_000);
	
	public static boolean isPrime(int n) {		
		return !primesUpTo1B[n];		
	}
	
	public static void main(String[] args) {
		double start = System.currentTimeMillis();		
		
		for (String n = "987654321"; n != null; n = decreasePermutation(n)) {
			if (isPrime(Integer.parseInt(n))) {
				System.out.println(n);
				break;
			}
		}
		
		double end = System.currentTimeMillis();
		double length = end - start;
		System.out.println("This took " + length + " ms.");	
	}

}
