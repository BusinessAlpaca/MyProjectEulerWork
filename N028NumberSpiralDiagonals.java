/*
 * Starting with the number 1 and moving to the right in a clockwise direction
 * a 5 by 5 spiral is formed as follows:
 * 
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 * 
 * */

public class N028NumberSpiralDiagonals {
	
	public static int sumDiagonalsOfSpiralWithSide(int n) {
		if (n< 2 || n % 2 == 0) {
			return 0;
		}
		
		int last = 1,	sum = 1;
		
		for (int sideLength = 3; sideLength <= n; sideLength = sideLength + 2) {
			for (int i = 1; i <=4; ++i) {
				last = last + (sideLength - 1);
				sum = sum + last;
			}			
		}
		return sum;
	}

	public static void main(String[] args) {		
		System.out.println(sumDiagonalsOfSpiralWithSide(1001));
	}

}
