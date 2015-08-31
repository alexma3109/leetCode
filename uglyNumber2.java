public class Solution {
    public int nthUglyNumber(int n) {
		int[] res = new int[n];
		res[0] = 1;
		int count = 1;
		int i = 0, j = 0, k = 0;
		while(count < n){
			int min = Math.min(Math.min(res[i] * 2, res[j] * 3), res[k] * 5);
			if(min == res[i] * 2){
				i++;
			}
			if(min == res[j] * 3){
				j++;
			}
			if(min == res[k] * 5){
				k++;
			}
			res[count] = min;
			count++;
		}
		return res[n - 1];
    }
}