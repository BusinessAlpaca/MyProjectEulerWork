/*
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible
 * permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed
 * numerically or alphabetically, we call it lexicographic order. The lexicographic
 * permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation of
 * the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * */

public class N024LexicographicPermutations2 {
	
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
	
	public static void main(String[] args) {
		String[] permutations = new String[10*9*8*7*6*5*4*3*2];
		permutations[0] = "0123456789";
		for (int i = 1; i < permutations.length; i ++) {
			permutations[i] = getNextPermutation(permutations[i-1]);
		}
		System.out.println(permutations[999999]);
	}

}
