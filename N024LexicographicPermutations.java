/*
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible
 * permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed
 * numerically or alphabetically, we call it lexicographic order. The lexicographic
 * permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation of
 * the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * */

import java.lang.StringBuilder;

public class N024LexicographicPermutations {
	
	public static int smallFactorial(int n) {
		if (n < 0 || n > 10) {
			return 0;
		}
		
		if (n == 0) {
			return 1;
		}
		
		return n * smallFactorial(n - 1);
		
	}
	
	public static String[] getPermutationsOfDigitsUpTo(int n) {
		if (n > 9) return null;
		
		if (n == 0) {
			String[] array = {"0"};
			return array;
		}
		
		String[] array = getPermutationsOfDigitsUpTo(n - 1);		
		String[] nextArray = new String[smallFactorial(n + 1)];
		for (int j = 0; j < array.length; j++) {
			for (int i = 0; i <= array[0].length(); i++) {
				nextArray[j * (array[0].length() + 1) + i] = new StringBuilder(array[j])
						.insert(i, Integer.toString(array[0].length()))
						.toString();			
			}
		}
		
		return nextArray;
	}

	public static String[] implementMergeSort(String[] array) {		
		if (array.length == 1) {
			return array;
		}
		
		String[] part1 = new String[array.length / 2];
		String[] part2 = new String[array.length - (array.length / 2)];

		System.arraycopy(array, 0, part1, 0, part1.length);
		System.arraycopy(array, part1.length, part2, 0, part2.length);
		
		part1 = implementMergeSort(part1);
		part2 = implementMergeSort(part2);
		
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < part1.length && j < part2.length) {
			 if (part1[i].compareTo(part2[j]) < 1) {
				 array[k] = part1[i];
				 i++;
				 k++;
			 } else {
				 array[k] = part2[j];
				 j++;
				 k++;
			 }
		 }
		
		while (j < part2.length) {
			array[k] = part2[j];
			j++;
			k++;
		}
		
		while (i < part1.length) {
			array[k] = part1[i];
			i++;
			k++;
		}
		
		
		return array;
	}
	
	public static void main(String[] args) {
		int n = 9;
		String[] permutations = getPermutationsOfDigitsUpTo(n);
		permutations = implementMergeSort(permutations);		
		System.out.println(permutations[999999]);
	}

}
