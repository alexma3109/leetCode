public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null){
            return 0;
        }
        /* dp[i] means the longest substring length contains s.charAt(i) */
        int[] dp = new int[s.length()]; 
        int open = 0;
        int max = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else if(s.charAt(i) == ')' && open > 0){ // found match //
                dp[i] = dp[i - 1] + 2; // length + 2 //
                dp[i] += (i - dp[i]) > 0 ? dp[i - dp[i]] : 0; 
                /* if the first char is included in the valid substring, then (i - dp[i]) = -1. */
                /* because i is the index and dp[i] is the length. */
                /* e.g "()", "((()))", "())))()))" */
                open--;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}