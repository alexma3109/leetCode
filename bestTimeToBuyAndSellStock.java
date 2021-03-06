public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for (int i = 0 ; i < prices.length ; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}