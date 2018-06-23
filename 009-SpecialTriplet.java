public class N009SpecialTriplet {

	public static boolean IsTriplet(int a, int b, int c) {
		if (a*a + b*b == c*c) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		while (a < 1000) {
			while (a + b < 1000) {
				int c = 1000 - a - b;
				if (IsTriplet(a, b, c)) {
					System.out.println(a*b*c);
					break;
				}
				b++;
			}
			a++;		
			b = a + 1;
		}
	}
}
