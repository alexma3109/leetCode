public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t)){
            return true;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        String newS = new String(charS);
        String newT = new String(charT);
        return newS.equals(newT);
    }
}