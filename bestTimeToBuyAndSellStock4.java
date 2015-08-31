//我们维护两种量，一个是当前到达第i天可以最多进行j次交易，最好的利润是多少（global[i][j]），
//另一个是当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少（local[i][j]）。
//global[i][j]=max(local[i][j],global[i-1][j])，
//也就是去当前局部最好的，和过往全局最好的中大的那个（因为最后一次交易如果包含当前天一定在局部最好的里面，否则一定在过往全局最优的里面）。
//对于局部变量的维护，递推式是
//local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
//也就是看两个量，第一个是全局到i-1天进行j-1次交易，然后加上今天的交易，如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），
//第二个量则是取local第i-1天j次交易，然后加上今天的差值（这里因为local[i-1][j]比如包含第i-1天卖出的交易，所以现在变成第i天卖出，并不会增加交易次数，
//而且这里无论diff是不是大于0都一定要加上，因为否则就不满足local[i][j]必须在最后一天卖出的条件了）。
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        if (k >= prices.length) return maxProfit2(prices);
		int[] g = new int[k + 1];
		int[] l = new int[k + 1];
		for(int i = 1 ; i < prices.length ; i++){
			for(int j = k ; j >= 0 ;j--){
				int diff = prices[i] - prices[i - 1];
				l[j] = Math.max(g[j - 1] + Math.max(diff, 0), l[j] + diff);
				g[j] = Math.max(g[j - 1], l[j]);
			}
		}
		return g[k];
	}
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;       
    }
}