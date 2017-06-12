/* DP && Stack */

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
                open++; // Do not put dp[i] = dp[i - 1], for extra invalid '(' //
            }
            else if(s.charAt(i) == ')' && open > 0){ // found match //
                dp[i] = dp[i - 1] + 2; // length + 2 //
                dp[i] += (i - dp[i]) > 0 ? dp[i - dp[i]] : 0; // add more if needed, like "()(())" //
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
/* Store index in Stack, pop pairs, count invalid chars' distance */
public class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(!stack.isEmpty() && s.charAt(i) == ')' && s.charAt(stack.peek()) == '(') {
                stack.pop();
            }
            else {
                stack.push(i);
            }
        }
        if(stack.isEmpty()){
            return s.length();
        }
        int max = s.length() - stack.peek() - 1; // distance between the last invalid char and the tail //
        while(stack.size() > 1) {
            max = Math.max(max, stack.pop() - stack.peek() - 1); // distance between two invalid chars //
        }
        max = Math.max(max, stack.pop()); // distance between the head and the first invalid char //
        return max;
    }
}