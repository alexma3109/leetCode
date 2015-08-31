public class Solution {
    public String shortestPalindrome(String s) {
		if(s.length() < 2){
			return true;
		}
		int len = 0;
		for(int i = s.length() ; i > 0 ; i--){
			if(isPalindrome(s.substring(0, i))){
				len = i;
				break;
			}
		}
		if(len == s.length()){
		    return s;
		}
		String prefix = new StringBuilder(s.substring(i)).reverse().toString();
		String res = prefix + s;
		return res;
    }
	public boolean isPalindrome(String s){
		if(s.length() < 2){
			return true;
		}
		int start = 0;
		int end = s.length() - 1;
		while(start < end){
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}