public class Solution {
    public boolean isMatch(String s, String p) {
        if((s == null && p == null) || s.equals(p){
			return true;
		}
		int star = -1, mark = -1;
		int i = 0, j = 0;
		while(i < s.length()){
			if(j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(s))){
				i++;
				j++;
			}
			else if(j < p.length() && p.charAt(j) == '*'){
				star = j;
				j++;
				mark = i;
			}
			else if(star != -1){
				j = star + 1;
				mark++;
				i = mark;
			}
			else{
				return false;
			}
		}
		while(j < p.length() &&  p.charAt(j) == '*'){
			j++;
		}
		return j == p.length();
    }
}