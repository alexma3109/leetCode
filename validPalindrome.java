public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1){
			return true;
		}
		s = s.replace(" ", "");
		s = s.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < s.length() ; i++){
			if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
				sb.append(s.charAt(i));
			}
		}
		String str = sb.toString();
		int start = 0, end = str.length() - 1;
		while(start < end){
			if(str.charAt(start) != str.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
    }
}