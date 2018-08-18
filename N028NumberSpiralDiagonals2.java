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

import java.util.Arrays;

public class N028NumberSpiralDiagonals2 {
	
	public static void buildSpiralHelper (int side, int[][] spiral, int row, int column, int last) {		
		if (last == 1) {
			spiral[row][column] = last;
			return;
		}
		
		for (int i = 0; i <= side - 1; ++i) {
			spiral[row][column - i] = last;
			--last;
		}
		for (int i = 1; i <= side - 1; ++i) {
			spiral[row + i][column - side + 1] = last;
			--last;
		}
		for (int i = 1; i <= side - 1; ++i) {
			spiral[row + side - 1][column - side + 1 + i] = last;
			--last;
		}
		for (int i = 1; i <= side - 2; ++i) {
			spiral[row + side - 1 - i][column] = last;
			--last;
		}
		buildSpiralHelper(side - 2, spiral, row + 1, column - 1, last);
		
	}
	
	
	public static int[][] buildSpiralWithSide(int side) {
		int[][] spiral = new int[side][side];
		buildSpiralHelper (side, spiral, 0, side - 1, side*side);
		return spiral;
	}	

	public static void main(String[] args) {
		int side = 1001;
		int[][] spiral = buildSpiralWithSide(side);
		int sum = 0;
		for (int i = 0; i < side; i++) {
			sum += spiral[i][i];
			sum += spiral[i][side -1 - i];
		}
		--sum;
		System.out.println(sum);
		
		

	}

}
