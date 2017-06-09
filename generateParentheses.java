public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n, 0, 0, "", list);
        return list;
    }
    public void helper(int n, int open, int close, String str, List<String> list) {
        if(open < close) {
            return;
        }
        if(open == n && close == n) {
            list.add(str);
            return;
        }
        if(open == n){ // open is full, can only add close parenthesis //
            helper(n, open, close + 1, str + ')', list);
            return;
        }
        helper(n, open + 1, close, str + '(', list);
        helper(n, open, close + 1, str + ')', list);
    }
}