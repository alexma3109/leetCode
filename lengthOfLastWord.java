public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        String[] cArray = s.split("\\s+");
        return cArray[cArray.length - 1].length();
    }
}