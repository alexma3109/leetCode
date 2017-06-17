public class Solution {
    public boolean isMatch(String s, String p) {
        if((s == null && p == null) || s.equals(p)){
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
				star = j; // keep the star index
				j++; // p moves to the next char but s remains
				mark = i; // mark current i
			}
			else if(star != -1){ // '*' is working
				j = star + 1; // target the next char after '*'
				mark++;	
				// mark keeps going until found matched char, 
				// mark will be that char index in s and plus 1,
				// so if that match isn't working later, it'll go and
				// find the next match.
				i = mark; // get marked index and do the checks in the next loop
			}
			else{
				return false;
			}
		}
		while(j < p.length() &&  p.charAt(j) == '*'){
			j++; // succeeding '*' in p is allowed
		}
		return j == p.length();
    }
}