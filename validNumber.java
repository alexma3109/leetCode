//eliminate space
//check +-
//isDigit-->num = true
//if '.' if (dot || exp) false, else set dot true
//if 'e' if (exp || !num) false, else set exp true, num false
//if +-, if(s.charAt(i - 1) != 'e') false
// else false
// i++
//return num;
public class Solution {
    public boolean isNumber(String s) {
		s = s.trim();
		int i = 0, end = s.length() - 1;
		if(i > end){
			return false;
		}
		boolean num, dot, exp;
		if(s.charAt(i) == '+' || s.charAt(i) == '-'){
			i++;
		}
		while(i <= end){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				num = true;
			}
			else if(c == '.'){
				if(exp || dot){
					return false;
				}
				dot = true;
			}
			else if(c == 'e'){
				if(exp || !num){
					return false;
				}
				exp = true;
				num = false;
			}
			else if(c == '+' || c == '-'){
				if(s.charAt(i - 1) != 'e'){
					return false;
				}
			}
			else{
				return false;
			}
			i++;
		}
		return num;
	}
}