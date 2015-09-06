public class Solution {////tricky test case will not pass////
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
		helper(s, wordDict, 0, "", res);
		return res;
    }
	public void helper(String s, Set<String> wordDict, int start, String str, List<String> res){
		if(start >= s.length()){
			res.add(str);
			return;
		}
		for(int i = start ; i < s.length() ; i++){
			String temp = s.substring(start, i + 1);
			if(wordDict.contains(temp)){
				String newStr = str.length() > 0 ? str + " " + temp : temp;
				helper(s, wordDict, i + 1, newStr, res);
			}
		}
	}
}

public class Solution2 {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s,dict,map);
    }

    public ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
        if(memo.containsKey(s)){
			return memo.get(s);	
		}
        ArrayList<String> result = new ArrayList<String>();
        int n = s.length();
        if(n <= 0){
			return result;	
		}
        for(int len = 1; len <= n; len++){
            String subfix = s.substring(0,len);
            if(dict.contains(subfix)){
                if(len == n){
                    result.add(subfix);
                }else{
                    String prefix = s.substring(len);
                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, memo);
                    for(String item:tmp){
                        item = subfix + " " + item;
                        result.add(item);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;    
    }
}