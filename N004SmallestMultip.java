
public class N004SmallestMultip {

	public static boolean isDivisible(long n) {
		int divisor = 1;
		while (divisor <= 20) {
			if (n%divisor != 0) return false;
			divisor++;
		}
		return true;
	}
	
	public static long cutdown() {
		long big = 1;
		int counter = 1;
		while (counter <= 20) {
			big = big * counter;
			counter++;
		}
		int divisor = 20;
		while (divisor > 1) {
			if ((big%divisor) == 0 && isDivisible(big/divisor)) {
				big = big/divisor;
			}
			divisor--;				
		}
		return big;
	}
	
	
	public static void main(String[] args) {
		System.out.println(cutdown());
	}

}
