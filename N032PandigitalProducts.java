/* We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
 * for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 * 
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier,
 * and product is 1 through 9 pandigital.
 * 
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 * 
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 * */

public class N032PandigitalProducts {
	
	public static boolean isPandigital (String str) {
		if (str.length() != 9) return false;
		if (!str.contains("1")) return false;
		if (!str.contains("2")) return false;
		if (!str.contains("3")) return false;
		if (!str.contains("4")) return false;
		if (!str.contains("5")) return false;
		if (!str.contains("6")) return false;
		if (!str.contains("7")) return false;
		if (!str.contains("8")) return false;
		if (!str.contains("9")) return false;		
		return true;		
	}
	
	public static boolean hasPandigitalIdentity (int num) {
		for (int i = 1; i <= 98; ++i) {
			if (num % i == 0) {
				String check = Integer.toString(i) + Integer.toString(num / i) + Integer.toString(num);
				if (isPandigital(check)) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		int sum = 0;
		for (int num = 1234; num <= 9876; ++num) {
			if (hasPandigitalIdentity(num)) sum += num;			
		}
		System.out.println(sum);
		
		double end = System.currentTimeMillis();
		double time = end - start;
		System.out.println("program runtime was " + time + " ms.");
	}

}
