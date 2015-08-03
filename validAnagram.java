public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t)){
            return true;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        String newS = new String(charS);
        String newT = new String(charT);
        return newS.equals(newT);
    }
    public boolean isAnagram(String s, String t) {
		if(s.equals(t)){
			return true;
		}
		if(s.length() != t.length()){
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0 ; i < s.length() ; i++){
			if(map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
			else{
				map.put(s.charAt(i), 1);
			}
		}
		for(int i = 0 ; i < t.length() ; i++){
			if(!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0){
				return false;
			}
			map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
		}
		return true;
	}
}