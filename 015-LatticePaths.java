/* Starting in the top left corner of a 2×2 grid, and only being able to move to the
 * right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 */

import java.math.BigInteger;

public class N015LatticePaths {

	/* On a grid allowing movement in only two directions, to get from
	 * coordinate (0,0) to coordinate (n,m), you need to take n many
	 * steps in the first direction, and m many steps in the second direction.
	 * So the number of paths between the two coordinates is equal to the number
	 * of ways in which you can choose m many steps from a series of steps which is 
	 * m+n steps long. The formula for this is:
	 * (m+n)!/(m!*n!) 
	 */
	
	public static BigInteger factorial(int n) {
		if (n < 2) {
			return BigInteger.ZERO;
		}
		
		if (n == 2) {
			return BigInteger.valueOf(2);
		}
		
		return BigInteger.valueOf(n).multiply(factorial(n-1));
		
	}
		

	public static BigInteger countPaths(int n, int m) {
		return factorial(n+m).divide(factorial(n).multiply(factorial(m)));
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(countPaths(20,20)); 

	}

}
