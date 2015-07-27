public class Solution {
    public String reverseWords(String s) {
		s = s.trim();
        String[] strings = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = strings.size() - 1 ; i >= 0 ; i--){
			if(strings[i] == ""){
				continue;
			}
			sb.append(strings[i]);
			if(i != 0){
				sb.append(" ");
			}
		}
		return sb.toString();
    }
}