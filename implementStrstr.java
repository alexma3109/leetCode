public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle) || needle.length() == 0) {
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }
        for(int i = 0 ; i < haystack.length() - needle.length() + 1 ; i++) {
            // i cannot be larger than haystack.length() - needle.length() + 1 //
            if(haystack.charAt(i) == needle.charAt(0)) {
                int pos = i;
                for(char c : needle.toCharArray()){
                    if(haystack.charAt(pos) != c){
                        break;
                    }
                    pos++;
                }
                if(pos - i == needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }
}