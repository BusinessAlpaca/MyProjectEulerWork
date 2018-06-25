
//Find the sum of all the primes below two million.

public class N010SumOfPrimes {

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

	public static long SumPrimesUnder(int limit) {
		if(limit < 2) return 0;
	    if(limit == 2) return 2;
	    if (limit == 3) return 5;
		long sum = 5;
		int i = 1;
		while (6 * i - 1 < limit) {
			if (IsPrime(6 * i - 1)) {
				sum += 6 * i - 1;
			}
			if (6 * i + 1 >= limit) break;
			if (IsPrime(6 * i + 1)) {
				sum += 6 * i + 1;	
			}
		i++;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(SumPrimesUnder(2000000));
	}

}
