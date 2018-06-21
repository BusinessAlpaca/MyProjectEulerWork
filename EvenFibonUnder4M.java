
public class EvenFibonUnder4M {

	public static void main(String[] args) {
		int NextFibon = 0;
		int FirstFibon = 1;
		int SecondFibon = 2;
		int SumOfEvenFibonUnder4M = 2;
		while (NextFibon < 4000000) {
			NextFibon = FirstFibon + SecondFibon;
					if (NextFibon % 2 == 0) {
						SumOfEvenFibonUnder4M += NextFibon;
					}
			FirstFibon = SecondFibon;
			SecondFibon = NextFibon;
		}
		System.out.println(SumOfEvenFibonUnder4M);
	}
}