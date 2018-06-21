
public class LargePalindrome {

	public static boolean isPalindrome(int n) {
		String word = Integer.toString(n);
		int i1 = 0;
		int i2 = word.length() -1;
		while (i2 > i1) {
			if (word.charAt(i1) != word.charAt(i2)) return false;
			++i1;
			--i2;
		}
		return true;
	}
	
	public static void largePalindrome () {
		int bigP = 0;
		int n=999;
		while (n>99) {
			int m=n;
			while (m>99) {
				if (isPalindrome(m*n) && bigP < m*n) {
					bigP = m*n;
				}
				m+= -1;
			}
		n += -1;
		}
		System.out.println(bigP);
	}
	
	
	public static void main(String[] args) {
		largePalindrome();
	}

}
