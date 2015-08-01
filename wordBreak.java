public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
		res[0] = true;
		for(int i = 1 ; i <= res.length ; i++){
			for(int j = 0 ; j < i ; j++){
				if(res[j] && wordDict.contains(s.substring(j, i))){
					res[i] = true;
				}
			}
		}
		return res[s.length()];
    }
}
//state function: res[i] = res[j] && wordDict.contains(s.substring(j, i));//
//i is not included//