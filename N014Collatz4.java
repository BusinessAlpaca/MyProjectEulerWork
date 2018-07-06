import java.util.ArrayList;

public class N014Collatz7 {
	
	public static ArrayList<Long[]> stepDown(ArrayList<Long[]> current) {		
		for (int i = 0; i < current.size(); i++) {
			if (current.get(i)[1] == 1) {
				current.remove(i);
				i--;
				continue;
			}
			else if (current.get(i)[1] % 2 == 0) {
				Long[] obj = new Long[2];
				obj[0] = current.get(i)[0];
				obj[1] = current.get(i)[1] / 2;
				current.set(i, obj);
			} else {
				Long[] obj = new Long[2];
				obj[0] = current.get(i)[0];
				obj[1] = current.get(i)[1] * 3 + 1;
				current.set(i, obj);
			}
		}		 
		return current;
	}
	
	public static void main(String[] args) {
		ArrayList<Long[]> current = new ArrayList<Long[]>();
		for (int i = 1; i < 1000000; i++) {
			Long[] obj = new Long[2];
			obj[0] = Long.valueOf(i);
			obj[1] = Long.valueOf(i);
			current.add(obj);
		}

		while (current.size() > 1) {			
			current = stepDown(current);
		}

		System.out.println(current.get(0)[0]);
		
	}

}
