
/*
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible
 * permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed
 * numerically or alphabetically, we call it lexicographic order. The lexicographic
 * permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation of
 * the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * */

import java.util.ArrayList;

public class N024LexicographicPermutations4 {

	public static ArrayList<String> getPermutationsOfDigitsUpToHelper(String perm, ArrayList<String> permutations, int maxDigit) {
		if (perm.length() >= maxDigit + 1) {
			permutations.add(perm);
			return permutations;
		}
		
		for (int digit = 0; digit <= maxDigit; digit++) {
			if (!perm.contains("" + digit)) {
				perm = perm + digit;
				getPermutationsOfDigitsUpToHelper(perm, permutations, maxDigit);
				perm = perm.substring(0, perm.length() - 1);
			}
		}
		return permutations;
	}
	
	public static ArrayList<String> getPermutationsOfDigitsUpTo(int maxDigit) {		
		ArrayList<String> permutations = new ArrayList<String>();
		permutations = getPermutationsOfDigitsUpToHelper("", permutations, maxDigit);
		return permutations;	
	}

	public static void main(String[] args) {
		ArrayList<String> permutations = getPermutationsOfDigitsUpTo(9);		
		System.out.println(permutations.get(999999));
	}

}
