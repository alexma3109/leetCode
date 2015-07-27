public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
		double res = 0;
		char flag = '';
		int i = 0;
		if(str.charAt(0) == '+' || str.charAt(0) == '-'){
			flag = str.charAt(0);
			i++;
		}
		while(i < str.length()){
			if(str.charAt(i) < '0' || str.charAt(i) > '9'){
				break;
			}
			res = res * 10 + (int)(str.charAt(i) - '0');
			i++;
		}
		if(flag == '-'){
			res = -res;
		}
		if(res > Intger.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		if(res < Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		return (int)res;
    }
}