public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
        	return false;
        }
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if(l != (m + n)){
        	return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1 ; i <= m ; i++){
        	if(dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)){
        		dp[i][0] = true;
        	}
        }
        for(int j = 1 ; j <= n ; j++){
        	if(dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1)){
        		dp[0][j] = true;
        	}
        }
        for(int i = 1 ; i <= m ; i++){
        	for(int j = 1 ; j <= n ; j++){
        		if(dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)){
        			dp[i][j] = true;
        		}
        		if(dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1 + i)){
        			dp[i][j] = true;
        		}
        	}
        }
        return dp[m][n];
    }
}