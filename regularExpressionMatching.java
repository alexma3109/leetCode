/* dp[i][j] is a string of length == i and a string of length == j */
/* So that is s.charAt(i - 1) and p.charAt(j - 1) */
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true; // both length == 0 is true //
        for(int j = 2 ; j <= p.length() ; j++) {
            if(p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            } // '*' can stands for 0 of preceding char //
        }
        // if s.length() != 0 && p.length() == 0, it's false //
        for(int i = 1 ; i <= s.length() ; i++) {
            for(int j = 1 ; j <= p.length() ; j++) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(j > 1 && p.charAt(j - 1) == '*') { // '*' cannot be the first char //
                    /* in this case, s length is still (i - 1), while p length is (j - 2) */
                    if(s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                        /* s of length == i <--> p of length (j - 1) --> 1 preceding char */
                        /* s of length == i <--> p of length (j - 2) --> 0 preceding char */
                        /* s of length == (i - 1) <--> p of length j --> 2 preceding char */
                    }
                    else {
                        dp[i][j] = dp[i][j - 2]; // '*' -> 0 of preceding char //
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

///////////////////////////////////////////////////////////////////

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
                    dp[i + 1][j + 1] = dp[i][j];//dp[x][y], x, y stands for length 
                }//so dp[i + 1][j + 1] <--> s.charAt(i), p.charAt(j)
                else if(p.charAt(j) == '.'){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                else if(p.charAt(j) == '*'){
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                        // dp[i][j + 1] -> * stands for multiple same chars //
                        // and s.charAt(i + 1) == s.charAt(i) //
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}