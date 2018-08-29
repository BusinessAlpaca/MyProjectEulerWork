import java.util.Arrays;

/* In England the currency is made up of pound, £, and pence, p, and
 * there are eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * 
 * It is possible to make £2 in the following way:
 * 
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * 
 * How many different ways can £2 be made using any number of coins? */

public class N031CoinSums {

	public static int getCoinValue (int coin) {
		switch (coin) {
		case 0: return 200;
		case 1: return 100;
		case 2: return 50;
		case 3: return 20;
		case 4: return 10;
		case 5: return 5;
		case 6: return 2;
		case 7: return 1;
		default: return 0;
		}
	}
	
	public static int[] getNextWalletWorth (int[] wallet, int sum) {
		//find start index
		int start = wallet.length - 1;
		for (int i = wallet.length - 2; i >= 0; --i) {
			if (wallet[i] > 0) {
				start = i;
				break;
			}
		}
		
		//get wallet value up to start index
		int value = 0;
		for (int i = 0; i < start; ++i) {
			value += wallet[i] * getCoinValue(i);
		}
		
		//update wallet
		--wallet[start];
		value += wallet[start] * getCoinValue(start);
		for (int i = start + 1; i < wallet.length; ++i) {
			wallet[i] = (sum - value) / getCoinValue(i);
			value += wallet[i] * getCoinValue(i);		
		}
		//System.out.println(Arrays.toString(wallet));
		return wallet;
	}
	
	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		int count = 1;
		int[] wallet = {1,0,0,0,0,0,0,0};
		int[] endWallet = {0,0,0,0,0,0,0,200};
		while (!Arrays.equals(wallet, endWallet)) {
			++count;
			wallet = getNextWalletWorth(wallet, 200);
		}
		System.out.println(count);
		
		double end = System.currentTimeMillis();
		double time = end - start;
		System.out.println("program runtime was " + time + " ms.");
	}
}
