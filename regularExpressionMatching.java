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
///////////////////////////////////////////////////////////////////
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // except dp[0][0], dp[i][0] are all false //
        // below loop is for the cases that p has useless prefix //
        for (int j = 1; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j - 1]; // based on the defination, when * equals 0 of previous char //
            } 
        }
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = 0 ; j < p.length() ; j++){
                if(p.charAt(j) == s.charAt(i)){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                else if(p.charAt(j) == '.'){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                else if(p.charAt(j) == '*'){
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}