/* The number, 1406357289, is a 0 to 9 pandigital number
 * because it is made up of each of the digits 0 to 9 in some order,
 * but it also has a rather interesting sub-string divisibility property.
 * 
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on.
 * In this way, we note the following:
 * 
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * 
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 * */

public class N043SubStringDivisibility {
	
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
	
	public static boolean hasDivisibilityProperty (String str) {		
		if (Integer.parseInt(str.substring(1, 4)) % 2 != 0) return false;
		if (Integer.parseInt(str.substring(2, 5)) % 3 != 0) return false;
		if (Integer.parseInt(str.substring(3, 6)) % 5 != 0) return false;
		if (Integer.parseInt(str.substring(4, 7)) % 7 != 0) return false;
		if (Integer.parseInt(str.substring(5, 8)) % 11 != 0) return false;
		if (Integer.parseInt(str.substring(6, 9)) % 13 != 0) return false;
		if (Integer.parseInt(str.substring(7)) % 17 != 0) return false;
		return true;
	}
	
	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		long sum = 0;
		for (String n = "1023456789"; n != null; n = getNextPermutation(n)) {
			if (hasDivisibilityProperty(n)) {
				sum += Long.parseLong(n);
			}
		}
		System.out.println(sum);		
		
		double end = System.currentTimeMillis();
		double length = end - start;
		System.out.println("This took " + length + " ms.");
	}
}
