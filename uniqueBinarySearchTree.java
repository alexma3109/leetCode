//// dp[0] 0 node, only 1 situation ////
//// dp[1] 1 node, only 1 situation ////
//// dp[i] i nodes in total, left branch has j nodes, right branch has i - j - 1 nodes////
//// j from 0 to i - 1, sum up ////
public class Solution {
    public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2 ; i <= n ; i++){
			for(int j = 0 ; j < i ; j++){
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];
	}
}