import java.util.ArrayList;

/* The following iterative sequence is defined for the set of positive integers:
 * n -> n/2 (n is even) n -> 3n + 1 (n is odd) Using the rule above and starting
 * with 13, we generate the following sequence: 13 - 40 - 20 - 10 - 5 - 16 - 8 -
 * 4 - 2 - 1 It can be seen that this sequence (starting at 13 and finishing at
 * 1) contains 10 terms. Although it has not been proved yet it is thought that
 * all starting numbers finish at 1. Which starting number, under one million,
 * produces the longest chain?
 */

public class N014Collatz7 {

	/*The stepDown method updates an arraylist of pairs of the form (number n, some number in n's Collatz sequence).
	 * The updating is done thus: If the original pair has the form (number n, 1), then that pair is removed from
	 * the arraylist. Otherwise, the original pair is replaced with the pair (same number n, the next number in n's Collatz sequence).
	 * The system ensures that the number of pairs cannot increase. Also, since all numbers (presumably) have 1 in their Collatz sequence,
	 * the system ensures that the number of pairs will quickly decrease.
	 */
	
	public static ArrayList<Integer[]> stepDown(ArrayList<Integer[]> current) {		
		for (int i = 0; i < current.size(); i++) {
			if (current.get(i)[1] == 1) {
				current.remove(i);
				i--;
				continue;
			}
			else if (current.get(i)[1] % 2 == 0) {
				Integer[] obj = new Integer[2];
				obj[0] = current.get(i)[0];
				obj[1] = current.get(i)[1] / 2;
				current.set(i, obj);
			} else {
				Integer[] obj = new Integer[2];
				obj[0] = current.get(i)[0];
				obj[1] = current.get(i)[1] * 3 + 1;
				current.set(i, obj);
			}
		}
		System.out.println(current.size()); //Test. prints out the size of the updates arraylist, so you can see it decreasing. 
		return current;
	}

	/*The program begins by creating an arraylist of pairs of the form (number n, number n). It sends this array to be updated by the stepDown method.
	 * This should lead to an arraylist with only one pair in it. Since this pair is the last to survive, the number which is the pair's first
	 * member must have the longest collatz sequence. The program should then print out that number. Unfortunately, the size of the arraylist of pairs stops
	 * shrinking once it has only 355 pairs. I have no clue why. 
	 */
	
	public static void main(String[] args) {
		ArrayList<Integer[]> current = new ArrayList<Integer[]>();
		for (int i = 1; i < 1000000; i++) {
			Integer[] obj = new Integer[2];
			obj[0] = i;
			obj[1] = i;
			current.add(obj);
		}

		while (current.size() > 1) {			
			current = stepDown(current);
		}

		System.out.println(current.get(0)[0]);
		
	}

}
