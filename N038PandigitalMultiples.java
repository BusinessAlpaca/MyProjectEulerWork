/* Take the number 192 and multiply it by each of 1, 2, and 3:
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * 
 * By concatenating each product we get the 1 to 9 pandigital, 192384576.
 * 
 * We will call 192384576 the concatenated product of 192 and (1,2,3)
 * 
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5,
 * giving the pandigital, 918273645, which is the concatenated product of 9 and
 * (1,2,3,4,5).
 * 
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed
 * as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 * */

public class N038PandigitalMultiples {
	
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
	
	public static String getConcatenatedProductOf (int integer) {		
		String str = Integer.toString(integer);		
		int n = 2;
		while (str.length() < 9) {
			str = str + Integer.toString(integer * n);
			++n;
		}
		
		return str;
	}

	public static void main(String[] args) {
		double start = System.currentTimeMillis();		
		
		int max = 0;
		for (int n = 1; n < 10_000; ++n) {
			String cp = getConcatenatedProductOf(n);
			if (isPandigital(cp)) {				
				max = Math.max(max,  Integer.parseInt(cp));
			}
		}
		System.out.println(max);
		
		double end = System.currentTimeMillis();
		double time = end - start;
		System.out.println("program runtime was " + time + " ms.");
	}

}
