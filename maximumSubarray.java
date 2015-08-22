public class Solution {
    public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int sum = 0;
		int max = Integer.MAX_VALUE;
		for(int i = 0 ; i < nums.length ; i++){
			sum += nums[i];
			max = Math.max(max, sum);
			sum = Math.max(max, 0);
		}
		return max;
    }
}