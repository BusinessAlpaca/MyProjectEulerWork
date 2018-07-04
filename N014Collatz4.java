import java.util.HashMap;

/* The following iterative sequence is defined for the set of positive integers:
 * n -> n/2 (n is even) n -> 3n + 1 (n is odd) Using the rule above and starting
 * with 13, we generate the following sequence: 13 - 40 - 20 - 10 - 5 - 16 - 8 -
 * 4 - 2 - 1 It can be seen that this sequence (starting at 13 and finishing at
 * 1) contains 10 terms. Although it has not been proved yet it is thought that
 * all starting numbers finish at 1. Which starting number, under one million,
 * produces the longest chain?
 */

public class N014Collatz4 {

	public static HashMap<Integer, Integer> stepDown(HashMap<Integer, Integer> current) {
		HashMap<Integer, Integer> next = new HashMap<Integer, Integer>();
		for (int i : current.keySet()) {
			if (current.get(i) % 2 == 0) {
				if (current.get(i) / 2 != 1) next.put(i, current.get(i) / 2);
			} else {
				next.put(i, current.get(i) *3 +1);				
			}
		}
		return next;
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> current = new HashMap<Integer, Integer>();
		for (int i = 1; i < 1000000; i++) {
			current.put(i, i);
		}

		while (current.size() > 1) {			
			System.out.println(current.size());
			current = stepDown(current);
		}

		for (int i : current.keySet()) System.out.println(i);
	
	}

}
