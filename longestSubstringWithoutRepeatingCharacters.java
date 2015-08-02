public class Solution {
    public int lengthOfLongestSubstring(String s) {
		char[] charS = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int minLen = 0;
		for(int i = 0 ; i < charS.length ; i++){
			if(!map.containsKey(charS[i])){
				map.put(charS[i], i);
			}
			else{
				minLen = minLen > map.size() ? minLen : map.size();
				i = map.get(charS[i]);
				map.clear();
			}
		}
		return minLen > map.size() ? minLen : map.size();
    }
}