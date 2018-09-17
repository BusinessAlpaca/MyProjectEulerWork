/* An irrational decimal fraction is created by concatenating the positive integers:
 * 0.123456789101112131415161718192021...
 * It can be seen that the 12th digit of the fractional part is 1.
 * 
 * If dn represents the nth digit of the fractional part, find the value
 *  of the following expression.
 *  
 *  d1 × d10 × d100 × d1_000 × d10_000 × d100_000 × d1_000_000
 * */

public class N040ChampernownesConstant {
	
	//bounds[0] = target index,
	//bounds[1] = lower bound number,
	//bounds[2] = upper bound number
	//bounds[3] = lower bound index,
	//bounds[4] = upper bound index
	public static int[] findStartHelper (int[] bounds) {		
		if (bounds[2] - bounds[1] <= 1) {
			return bounds;
		}
		
		int update = (bounds[1] + bounds[2]) / 2;
		int updateDigitNumber = Integer.toString(update).length();
		int updateIndex = 0;
		int countNumbersWithFewerDigits = 0;
		for (int i = 1; i < updateDigitNumber; ++i) {
			countNumbersWithFewerDigits += 9 * (int) Math.pow(10, i - 1);
			updateIndex += 9 * (int) Math.pow(10, i - 1) * i;			
		}
		updateIndex += (update - countNumbersWithFewerDigits - 1) * updateDigitNumber + 1;
		
		if (updateIndex < bounds[0]) {
			bounds[1] = update;
			bounds[3] = updateIndex;
			return findStartHelper(bounds);
		} else if (updateIndex > bounds[0]) {
			bounds[2] = update;
			bounds[4] = updateIndex;
			return findStartHelper(bounds);
		} else {
			bounds[1] = update;
			bounds[3] = updateIndex;
			bounds[2] = update;
			bounds[4] = updateIndex;
			return findStartHelper(bounds);
		}
	}
	
	public static int[] findStart (int index) {
		int[] bounds = {index, 1, index, 1, index};
		return findStartHelper(bounds);		
	}
	
	public static int getDigitAtIndex (int[] bounds) {
		String sequence = Integer.toString(bounds[1]) + Integer.toString(bounds[2]);
		return Character.getNumericValue(sequence.charAt(bounds[0] - bounds[3]));
	}

	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		System.out.println(getDigitAtIndex(findStart(1)) *
				getDigitAtIndex(findStart(10)) *
				getDigitAtIndex(findStart(100)) *
				getDigitAtIndex(findStart(1_000)) *
				getDigitAtIndex(findStart(10_000)) *
				getDigitAtIndex(findStart(100_000)) *
				getDigitAtIndex(findStart(1_000_000))
				);
		
		double end = System.currentTimeMillis();
		double length = end - start;
		System.out.println("This took " + length + " ms.");	
	}

}
