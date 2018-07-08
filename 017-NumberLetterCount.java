/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then
 * there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
 * how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two)
 * contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.*/

public class N017NumberLetterCount {

	public static String basicTranslate(int n) {
		switch (n) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirteen";
		case 14:
			return "fourteen";
		case 15:
			return "fifteen";
		case 16:
			return "sixteen";
		case 17:
			return "seventeen";
		case 18:
			return "eighteen";
		case 19:
			return "nineteen";
		case 20:
			return "twenty";
		case 30:
			return "thirty";
		case 40:
			return "forty";
		case 50:
			return "fifty";
		case 60:
			return "sixty";
		case 70:
			return "seventy";
		case 80:
			return "eighty";
		case 90:
			return "ninety";
		case 1000:
			return "onethousand";
		default:
			return "";
		}
	}

	public static String twoDigitTranslate(int n) {
		String basic = basicTranslate(n);
		if (!basic.equals(""))
			return basic;
		
		String twoDigit = Integer.valueOf(n).toString();
		return basicTranslate(Integer.valueOf(twoDigit.substring(0, 1) + "0"))
				+ basicTranslate(Integer.valueOf(twoDigit.substring(1)));
	}

	public static String threeDigitTranslate(int n) {
		String threeDigit = Integer.valueOf(n).toString();

		if (n % 100 == 0)
			return basicTranslate(Integer.valueOf(threeDigit.substring(0, 1))) + "hundred";

		return basicTranslate(Integer.valueOf(threeDigit.substring(0, 1))) + "hundredand"
				+ twoDigitTranslate(Integer.valueOf(threeDigit.substring(1)));
	}

	public static String buildString(int n) {
		if (n < 1 || n > 1000)
			return "";

		String basic = basicTranslate(n);
		if (!basic.equals(""))
			return basic;

		if (n < 100)
			return twoDigitTranslate(n);
		
		return threeDigitTranslate(n);

	}

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 1001; i++) {
			sum += buildString(i).length();
		}
		System.out.println(sum);
	}

}
