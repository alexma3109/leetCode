//// any integer, can be added up by at most 4 perfect square numbers ////
public class Solution {
    public int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 1 ; i * i <= n ; i++){
			dp[i * i] = 1;
		}
		for(int i = 1 ; i < n ; i++){
			for(int j = 1 ; i + j * j <= n ; j++){
				dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
			}
		}
		return dp[n];
	}
}