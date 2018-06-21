
public class N006SumSquareDiff {

	public static int SumOfSquares(int n) {
		int m = 0;
		int sumOfSquares = 0;
		while (m<= n) {
			sumOfSquares += m*m;
			m++;
		}
		return sumOfSquares;
	}
	
	public static int SquareOfSum (int n) {
		int m = 0;
		int sum = 0;
		while (m<=n) {
			sum += m;
			m++;
		}
		return sum*sum;
	}
	
	public static void main(String[] args) {
		System.out.println(SquareOfSum(100) - SumOfSquares(100));
	}

}
