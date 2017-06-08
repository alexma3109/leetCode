public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String res = strs[0];
        for(String str : strs) {
            res = str.length() < res.length() ? str : res;
        }
        int j = 0;  // Once not match, only resume matching from break position
                    // all strings before will be fine for sure
        for(int i = res.length() ; i > 0 ; i--) {
            String temp = res.substring(0, i);
            while(j < strs.length) {
                if(!strs[j].substring(0, i).equals(temp)){
                    break;
                }
                j++;
            }
            if(j == strs.length){
                return temp;
            }
        }
        return "";
    }
}