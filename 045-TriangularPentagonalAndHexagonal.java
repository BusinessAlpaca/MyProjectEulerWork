/* Triangle, pentagonal, and hexagonal numbers are generated
 * by the following formulae:
 * 
 * Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
 * 
 * Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
 * 
 * Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
 * 
 * It can be verified that T285 = P165 = H143 = 40755.
 * 
 * Find the next triangle number that is also pentagonal and hexagonal.
 * */

//note that T(2m-1) = H(m). Therefore:
//it's enough to generate Hexagonals and check for Pentagonality

public class N045TriangularPentagonalAndHexagonal {
	
	public static boolean isPentagonal(long n) {
		double inverse = (1 + Math.sqrt(1 + 24 * n)) / 6;
		return inverse == (int) inverse;
	}	

	public static long getHexagonal(long n) {
		return n * (2 * n - 1);
	}	

	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		long i = 144;
		long t = getHexagonal(i);
		while (!isPentagonal(t)) {
			++i;
			t = getHexagonal(i); 
		}
		System.out.println(t);
		
		double end = System.currentTimeMillis();
		double length = end - start;
		System.out.println("This took " + length + " ms.");

	}

}
