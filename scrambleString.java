//// len is the length of considering part // len from 2 to <= n ////
//// i is the start index of s1 // i from 0 to < n - len + 1 ////
//// j is the start index of s2 // j from 0 to < n - len + 1 ////
//// k is the left sub-part of the considering part // k from 1 to len - 1 ////
public class Solution {
    public boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length()){
			return false;
		}
		if(s1.equals(s2)){
			return true;
		}
		int n = s1.length();
		boolean[][][] dp = new boolean[n + 1][n][n];
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
			}
		}
		for(int len = 2 ; len <= n ; len++){
			for(int i = 0 ; i < n - len + 1 ; i++){
				for(int j = 0 ; j < n - len + 1 ; j++){
					boolean temp = false;
					for(int k = 1 ; k < len ; k++){
						if((dp[k][i][j] && dp[len - k][i + k][j + k]) || (dp[k][i][j + len - k] && dp[len - k][i + k][j])){
							temp = true;
							break;
						}
					}
					dp[len][i][j] = temp;
				}
			}
		}
		return dp[n][0][0];
	}
}
//// recursion solution ////
public class Solution {
    public boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length()){
			return false;
		}
		if(s1.equals(s2)){
			return true;
		}
		for(int i = 1 ; i < s1.length() ; i++){
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);
			if(isScramble(s11, s21) && isScramble(s12, s22)){
				return true;
			}
			if(isScramble(s11, s22) && isScramble(s12, s21)){
				return true;
			}
		}
		return false;  
	}
}