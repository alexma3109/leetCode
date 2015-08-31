public class Solution {
    public int maxProfit(int[] prices) {
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		int min = 0;
		left[0] = 0;
		right[[prices.length - 1]] = 0;
		for(int i = 1 ; i < prices.length ; i++){
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}
		for(int i = prices.length - 2 ; i>= 0 ; i--){
			min = Math.min(min, prices[i]);
			right[i] = Math.max(right[i + 1], prices[i] - min);
		}
		int profit = 0;
		for(int i = 0 ; i < prices.length ; i++){
			profit = Math.max(left[i] + right[i], profit);
		}
		return profit;
	}
}