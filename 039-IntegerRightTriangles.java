/*
 * If p is the perimeter of a right angle triangle with integral
 * length sides, {a,b,c}, there are exactly three solutions for p = 120.
 * 
 * {20,48,52}, {24,45,51}, {30,40,50}
 * 
 * For which value of p ≤ 1000, is the number of solutions maximised?
 * */

import java.util.HashSet;

public class N039IntegerRightTriangles {
	
	public static int countTriangles(int p) {
		HashSet sides = new HashSet<Integer>();
		for (int a = 1; a < p / 2; ++a) {
			if (sides.contains(a)) {
				continue;
			}
			double b = p * (2 * a - p) / (2 * (a - p));  //because c = p - a - b; c^2 = a^2 + b^2.
			if (b % 1 == 0) {
				int bee = (int) b;
				int c = p - a - bee;
				if (c * c == a * a + bee * bee) {
					// System.out.println(a + "," + bee + "," + c);
					sides.add(bee);
				}
			}
		}
		return sides.size();
	}	

	public static void main(String[] args) {
		double start = System.currentTimeMillis();

		int bestP = 0;
		int maxTs = 0;

		for (int p = 1; p < 1001; ++p) {
			int count = countTriangles(p);
			if (count > maxTs) {
				maxTs = count;
				bestP = p;
			}
		}
		System.out.println(bestP);
		
		double end = System.currentTimeMillis();
		double length = end - start;
		System.out.println("This took " + length + " ms.");
	}

}
