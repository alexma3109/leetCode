public class Solution {
    public void rotate(int[] nums, int k) {
		int n = nums.length;
	    while(n <= k){
	        k = k - n;
	    }
		if(k == 0){
			return;
		}
        for(int i = 0 ; i < n / 2 ; i++){
			int temp = nums[i];
			nums[i] = nums[n - 1 - i];
			nums[n - 1 - i] = temp;
		}
		for(int i = 0 ; i < k / 2; i++){
			int temp = nums[i];
			nums[i] = nums[k - i - 1];
			nums[k - i - 1] = temp;
		}
		for(int i = k ; i < (n + k) / 2 ; i++){
			int temp = nums[i];
			nums[i] = nums[n + k - i - 1];
			nums[n + k - i - 1] = temp;
		}
    }
}