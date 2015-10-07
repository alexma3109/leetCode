public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null){
			return false;
		}
		HashMap<Character, String> map = new HashMap<Character, String>();
		char[] patArray = pattern.toCharArray();
		String[] strArray = str.split(" ");
		if(patArray.length != strArray.length){
			return false;
		}
		int n = patArray.length;
		for(int i = 0 ; i < n ; i++){
			if(map.containsKey(patArray[i])){
				if(!map.get(patArray[i]).equals(strArray[i]){
					return false;
				}
			}
			else if(map.containsValue(strArray[i])) {
				return false;
			}
			else{
				map.put(patArray[i], strArray[i]);
			}
		}
		return true;
    }
}