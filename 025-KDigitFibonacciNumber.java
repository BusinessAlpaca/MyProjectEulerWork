/*The Fibonacci sequence is defined by the recurrence relation:
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * 
 * Hence the first 12 terms will be:
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * 
 * The 12th term, F12, is the first term to contain three digits.
 * What is the index of the first term in the Fibonacci sequence
 * to contain 1000 digits? 
 * */

public class KDigitFibonacciNumber {
	
	public static int[] columnSum (int n, int m, int carry) {
		int sum = n + m + carry;
		int lastDigit = sum % 10;
		carry = sum / 10;
		int[] result = {lastDigit, carry};
		return result;
	}
	
	public static String stringSum (String small, String big) {		
		
		if (small.length() < big.length()) {
			String zeros = "";
			int diff = big.length() - small.length();
			for (int i = 0; i < diff; i++) {
				zeros += "0"; 
			}
			small = zeros + small;
		}
		
		String sum = "";
		int carry = 0;
		for (int i = big.length() - 1; i >= 0; i--) {
			int[] result = columnSum(Character.getNumericValue(big.charAt(i)), Character.getNumericValue(small.charAt(i)), carry);
			sum = Integer.toString(result[0]) + sum;
			carry = result[1];
		}
		
		if (carry != 0) {
			sum = Integer.toString(carry) + sum;
		}
		
		return sum;	
	}

	public static void main(String[] args) {
		String fib1 = "1", fib2 = "1", temp = "";
		int counter = 2;
		while (true) {
			temp = fib2;
			fib2 = stringSum(fib1, fib2);
			fib1 = temp;
			counter++;
			
			if (fib2.length() >= 1000) {
				System.out.println(counter);
				return;
			}
		}
	}
}
