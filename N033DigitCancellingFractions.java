import java.util.Arrays;

/* The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify
 * it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 * 
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * 
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 * */
public class N033DigitCancellingFractions {

	public static boolean isDigitCancellingFraction(int numerator, int denominator) {
		if (numerator < 10 || numerator > 99 || denominator < 10 || denominator > 99) {
			return false;
		}

		double[] digits = { (double) (numerator / 10), (double) (numerator % 10), (double) (denominator / 10),
				(double) (denominator % 10) };
		double fraction = (double) (numerator) / (double) (denominator);
		double test = 0.0;

		for (int i = 0; i < 2; ++i) {
			for (int j = 2; j < 4; ++j) {
				if (digits[i] != 0 && digits[i] == digits[j]) {
					test = digits[1 - i] / digits[5 - j];
					if (test == fraction) {
						//System.out.println(Arrays.toString(digits));
						return true;
					}
				}
			}
		}
		return false;
	}

	public static int[] minimizeFraction(int numerator, int denominator) {
		int[] primes = {2, 3, 5, 7, 11,
				13,	17, 19, 23, 29, 
				31, 37, 41, 43, 47,
				53, 59, 61, 67, 71,
				73, 79, 83, 89, 97};		
		int p = 0;
		
		while (p < primes.length) {
			if (numerator % primes[p] == 0 && denominator % primes[p] == 0) {
				numerator = numerator / primes[p];
				denominator = denominator / primes[p];
			} else {
				++p;
			}
		}
		
		int[] minimized = {numerator, denominator};
		return minimized;
	}
	
	public static void main(String[] args) {
		double start = System.currentTimeMillis();

		int numerProd = 1;
		int denomProd = 1;
		for (int i = 10; i < 100; ++i) {
			for (int j = i + 1; j < 100; ++j) {
				if (isDigitCancellingFraction(i, j)) {
					numerProd *= i;
					denomProd *= j;
				}
			}
		}		
		System.out.println(minimizeFraction(numerProd, denomProd)[1]);

		double end = System.currentTimeMillis();
		double time = end - start;
		System.out.println("program runtime was " + time + " ms.");
	}

}
