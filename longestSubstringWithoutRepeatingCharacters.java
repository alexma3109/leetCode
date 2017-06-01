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

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        int max = 0, length = 0;
        HashSet<Character> set = new HashSet<>();
        int head = 0, tail = 0;
        while(head <= tail && tail < s.length()){
        	if(!set.contains(s.charAt(tail))){
        		set.add(s.charAt(tail));
        		length++;
        		tail++;
        		continue;
        	}
        	max = Math.max(max, length);
        	while(set.contains(s.charAt(tail))){
        		set.remove(s.charAt(head));
        		head++;
        		length--;
        	}
        }
        max = Math.max(max, length);
        return max;        
    }
}