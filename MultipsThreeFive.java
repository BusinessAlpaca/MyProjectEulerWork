
public class MultipsThreeFive {

	public static int IsMultipleOfThreeOrFive(int number) {
		if (number % 3 == 0 || number % 5 == 0) {
			return number;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		int n = 0;
		int SumOfMultiplesUnderK = 0;
		while (n < 1000) {
			SumOfMultiplesUnderK += IsMultipleOfThreeOrFive(n);
			n++;
		}
		System.out.println(SumOfMultiplesUnderK);

	}

}
