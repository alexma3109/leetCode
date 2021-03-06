public class Solution {
    public int numDecodings(String s) {
        if(s == null){
            return 0;
        }
        int n = s.length();
        if(n == 0 || s.equals("0")){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2 ; i <= n ; i++){
            if(isValid(s.substring(i - 1, i))){
                dp[i] = dp[i - 1];
            }
            if(isValid(s.substring(i - 2, i))){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
    private boolean isValid(String s){
        if(s.charAt(0) == '0'){
            return false;
        }
        int num = Integer.parseInt(s);
        return (num >= 1 && num <= 26);
    }
}