import java.lang.Math;

public class MaxProfitOneTransaction {
	public static void main(String[] args) {
		int[] prices = {200, 500, 1000, 700, 30, 400, 900, 400, 550};

		System.out.println(maxProfitOneTransaction(prices));
	}

	private static int maxProfitOneTransaction(int[] prices) {
		int cheapest = prices[0];
		int maxProfit = 0;

		for(int i = 1; i < prices.length; i++) {
			maxProfit = Math.max(maxProfit, prices[i] - cheapest);
			cheapest = Math.min(cheapest, prices[i]);
		}
		
	return maxProfit;
	}
}


