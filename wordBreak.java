/* time O(n^2), space O(n) */
//state function: res[i] = res[j] && wordDict.contains(s.substring(j, i));//
//i is not included//
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        Iterator iter = wordDict.iterator();
        while (iter.hasNext()) {
            set.add((String) (iter.next()));
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1 ; i <= s.length() ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}