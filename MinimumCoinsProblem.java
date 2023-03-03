import java.lang.Integer;

public class MinimumCoinsProblem {	
	public static void main(String... args) {
		int[] coins = {25, 10, 5, 1 };
		int coinsLength = coins.length;
		int amount = 48;
		
		System.out.println(minCoins(coins, coinsLength, amount));
	
	}

	private static int minCoins(int[] coins, int coinsLength, int amount) {
		int[] table = new int[amount + 1];
	
		for(int i = 1; i < table.length; i++) {
			table[i] = Integer.MAX_VALUE;
		}

		table[0] = 0;

		for(int i = 1; i < table.length; i++) {
			for(int j = 0; j < coinsLength; j++) {
				if(coins[j] <= i) {
					int remaining = i - coins[j];
					table[i] = Math.min(table[i], table[remaining] + 1);
				}
			}
		}

		if(table[amount] == Integer.MAX_VALUE) {
			return -1;
        	}

  		return table[amount];
	}
}


