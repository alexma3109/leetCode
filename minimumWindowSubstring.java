public class Solution {
    public String minWindow(String s, String t) {
        HashMap<character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0 ; i < t.length() ; i++){
			if(map.containsKey(t.charAt(i))){
				map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
			}
			else{
				map.put(t.charAt(i), 1);
			}
		}
		int minLen = s.length() + 1;
		int left = 0;
		int minStart = 0;
		int count = t.length();
		for(i < 0 ; i < s.length() ; i++){
			if(map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
				if(map.get(s.charAt(i) >= 0)){
					count--;
				}
				while(count == t.length()){
					int len = i - left + 1;
					if(len < minLen){
						minLen = len;
						minStart = left;
					}
					if(map.containsKey(s.charAt(left))){
						map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
						if(map.get(s.charAt(left) > 0)){
							count--;
						}
					}
					left++;
				}
			}
		}
		if(minLen > s.length()){
			return "";
		}
		return s.substring(minStart, minStart + minLen);
    }
}