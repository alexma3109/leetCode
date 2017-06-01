/* Only consider the substring end with index i */
/* Only consider substring length > current res length */
/* O(n) time complexcity */
public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        if(s == null || s.length() == 0){
            return res;
        }
        int len = res.length();
        for(int i = 0 ; i < s.length() ; i++) {
            if(isPalindrome(s, i - len - 1, i)) {
                res = s.substring(i - len - 1, i + 1);
                len = res.length(); // equal to len += 2; //
            }
            else if(isPalindrome(s, i - len, i)) {
                res = s.substring(i - len, i + 1);
                len = res.length(); // equal to len++; //
            }
        }
        return res;
    }
    public boolean isPalindrome(String s, int head, int tail) {
        if(head < 0){
            return false;
        }
        while(head < tail){
            if(s.charAt(head) != s.charAt(tail)){
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}