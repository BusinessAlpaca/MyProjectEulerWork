
public class N007NthPrime {
	
	public static boolean IsPrime(int m) {
		if(m < 2) return false;
	    if(m == 2 || m == 3) return true;
	    if(m%2 == 0 || m%3 == 0) return false;
	    int i = 6;
	    while  (i <= (int)Math.sqrt(m) + 1) {
	    	if (m%(i-1) == 0 || m%(i+1) == 0) return false;
	    	i += 6;
	    }
	    return true;
	}
	
	public static int NthPrime (int n) {
		if(n < 1) return 0;
	    if(n == 1) return 2;
	    if (n == 2) return 3;
		int counter = 2;
		int i = 1;
		int lastPrime = 0;
		while (counter <= n) {
			if (IsPrime(6 * i - 1)) {
				lastPrime = 6 * i - 1;
				counter++;
				if (counter == n) break;
			}
			if (IsPrime(6 * i + 1)) {
				lastPrime = 6 * i + 1;
				counter++;
				if (counter == n) break;
			}
			i++;
		}
		return lastPrime;
	}

	public static void main(String[] args) {
		System.out.println(NthPrime(10001));
	}

}
