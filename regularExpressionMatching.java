public class Solution {
    public boolean isMatch(String s, String p) {
		if(p.length() == 0){
			if(s.length() == 0){
				return true;
			}
			return false;
		}
		if(p.length() == 1 || p.charAt(1) != '*'){
			if(s.length() < 1 || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))){
				return false;
			}
			return isMatch(s.subString(1), p.subString(1);
		}
		else{
			int len = s.length();
			int i = -1;
			while(i < len && (i < -1 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
				if(isMatch(s.subString(i + 1), p.subString(2))){
					return true;
				}
				i++;
			}
			return false;
		}
    }
}