/* The decimal number, 585 = 10010010012 (binary),
 * is palindromic in both bases.
 * 
 * Find the sum of all numbers, less than one million,
 * which are palindromic in base 10 and base 2.
 * 
 * (Please note that the palindromic number, in either base,
 * may not include leading zeros.)
 * */

public class N036DoubleBasePalindromes {
	
	public static boolean isPalindrome (String n) {		
		int length = n.length();
		for (int i = 0; i < length / 2; ++i) {
			if (n.charAt(i) != n.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;		
	}

	public static String toBinaryHelper (String n, String suffix) {	
		if (Integer.parseInt(n) == 0) {
			if (suffix.equals("")) {
				return "0";
			}
			return suffix;
		}
		
		int digit = Integer.parseInt(n) % 2;
		int rest =  Integer.parseInt(n) / 2;		
		return toBinaryHelper(Integer.toString(rest), Integer.toString(digit) + suffix);
	}
	
	public static String toBinary (String n) {
		return toBinaryHelper (n, "");
	}
	
	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		int sum = 0;
		for (int n = 1; n < 1_000_000; ++n) {
			if (isPalindrome(Integer.toString(n))) {
				if (isPalindrome(toBinary(Integer.toString(n)))) {
					sum += n;
				}
			}
		}
		System.out.println(sum);
		
		double end = System.currentTimeMillis();
		double time = end - start;
		System.out.println("program runtime was " + time + " ms.");
	}

}
