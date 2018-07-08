/*215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
	 * What is the sum of the digits of the number 2^1000?*/
	

import java.math.BigInteger;


public class N016PowerDigitSum {

	public static void main(String[] args) {
		String n = BigInteger.valueOf(2).pow(1000).toString();
		int digitSum = 0;
		for (int i = 0; i < n.length(); i++) {
		digitSum += Character.getNumericValue(n.charAt(i));
		}
		System.out.println(digitSum);

	}

}
