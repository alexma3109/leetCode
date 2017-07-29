/* time O(n) */
/* Once found diff, if length equal, compare the substring i, i */
/* if s longer, s.substring(i + 1) <--> t.substring(i) */
/* Don't simply return false at the end */

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        for (int i = 0 ; i < Math.min(s.length(), t.length()) ; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));
                }
                else {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}