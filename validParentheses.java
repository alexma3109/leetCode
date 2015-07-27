public class Solution {
    public boolean isValid(String s) {
		if(s.length() % 2 != 0){
			return false;
		}
        HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i < s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				stack.push(s.charAt(i));
			}
			if(map.containsValue(s.charAt(i))){
				if(stack.isEmpty()){
					return false;
				}
				char temp = stack.pop();
				if(map.get(temp) != s.charAt(i)){
					return false;
				}
			}
		}
		return stack.isEmpty();
    }
}