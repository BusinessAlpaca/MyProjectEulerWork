
public class largestPrimeFactor2 {
	
	public static boolean IsPrime(long m) {
		if(m < 2) return false;
	    if(m == 2 || m == 3) return true;
	    if(m%2 == 0 || m%3 == 0) return false;
	    long i = 6;
	    while  (i <= (long)Math.sqrt(m) + 1) {
	    	if (m%(i-1) == 0 || m%(i+1) == 0) return false;
	    	i += 6;
	    }
	    return true;
	}
	
	public static long findFromTop(long n) {
		long divisor = 2;
		while (divisor <= Math.sqrt(n)) {
			if (n%divisor == 0) {
				long big = n/divisor;
				if (IsPrime(big)) {
					return big;
				}
			}
			divisor++;
		}
		return 0;
	}
	
	public static long findFromBottom(long n) {
		long divisor = (long)Math.sqrt(n);
		while (divisor > 0) {
			if (n%divisor == 0) {
				if (IsPrime(divisor)) {
					return divisor;
				}
			}
			divisor += -1;
		}
		return 0;
	}
	
	public static void findLargestPrimeFactor(long n) {
		if (findFromTop(n) != 0) {
			System.out.println(findFromTop(n));
		} else if (findFromBottom(n) != 0) {
			System.out.println(findFromBottom(n));
		} else {
			System.out.println(n);
		}
	}
		

	public static void main(String[] args) {
		findLargestPrimeFactor(600851475143L);
	}

}