public class Solution {
    public int calculate(String s) {
		String[] tokens = toRPN(s).split("\\s+");
		Stack<String> stack = new Stack<String>();
		int res = 0;
		for(String str : tokens){
			if(!str.equals("+") && !str.equals("-")){
				stack.push(str);
			}
			else{
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				if(str.equals("+")){
					stack.push(String.valueOf(a + b));
				}
				else{
					stack.push(String.valueOf(b - a));
				}
			}
		}
		res = Integer.valueOf(stack.pop());
		return res;
	}
////Reverse Polish Notation////
	public String toRPN(String s){
		if(s == null || s.length() == 0){
			return "";
		}
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < s.length() ; i++){
			if(s.charAt(i) == '+' || s.charAt(i) == '-'){
				while(!stack.isEmpty() && stack.peek() != '('){
					sb.append(" ");
					sb.append(stack.pop());
				}
				sb.append(" ");
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == '('){
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == ')'){
				while(!stack.isEmpty() && stack.peek() != '('){
					sb.append(" ");
					sb.append(stack.pop());
				}
				stack.pop();
			}
			else if(s.charAt(i) == ' '){
				continue;
			}
			else{
				sb.append(s.charAt(i));
			}
		}
		while(!stack.isEmpty()){
			sb.append(" ");
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}