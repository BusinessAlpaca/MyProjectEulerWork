
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
import java.lang.StringBuilder;

public class N024LexicographicPermutations5 {

	public static ArrayList<String> permuteHelper(String perm, ArrayList<String> permutations, String str) {
		if (str.length() <= 0) {
			permutations.add(perm);
			return permutations;
		}		
		
		for (int i = 0; i < str.length(); i++) {			
			char chosen = str.charAt(i);
			perm = perm + Character.toString(chosen);
			StringBuilder sb = new StringBuilder(str);
			sb.deleteCharAt(i);
			permuteHelper(perm, permutations, sb.toString());
			perm = perm.substring(0, perm.length() - 1);
		}
		return permutations;
	}
	
	public static ArrayList<String> permute(String str) {		
		ArrayList<String> permutations = new ArrayList<String>();
		permutations = permuteHelper("", permutations, str);
		return permutations;	
	}

	public static void main(String[] args) {
		ArrayList<String> permutations = permute("0123456789");
		System.out.println(permutations.get(999999));
	}

}
