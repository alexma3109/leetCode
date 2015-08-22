public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = digits.length - 1 ; i >= 0 ; i--){
			int sum = digits[i] + carry;
			if(sum >= 10){
				carry = 1;
				sum = sum - 10;
			}
			else{
				carry = 0;
			}
			temp.add(sum);
		}
		if(carry == 1){
			temp.add(1);
		}
		int[] res = new int[temp.size()];
		for(int i = 0 ; i < temp.size() ; i++){
			res[temp.size() - 1 - i] = temp.get(i);
		}
		return res;
    }
}