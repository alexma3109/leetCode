//for each operator, recursive check left and right

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        int n = input.length();
		List<Integer> res = new ArrayList<Integer>();
		if(input == null || n == 0){
			return res;
		}
		for(int i = 0 ; i < input.length() ; i++){
			char c = input.charAt(i);
			if(c != '+' && c != '-' && c != '*'){
				continue;
			}
			List<Integer> partA = diffWaysToCompute(s.substring(0, i));
			List<Integer> partB = diffWaysToCompute(s.substring(i + 1, n));
			for(Integer numA : partA){
				for(Integer numB : partB){
					if(c == '+'){
						res.add(numA + numB);
					}
					if(c == '-'){
						res.add(numA - numB);
					}
					if(c == '*'){
						res.add(numA * numB);
					}					
				}
			}
		}
		if(res.size() == 0){
			res.add(Integer.parseInt(input));
		}
		return res;
	}
}