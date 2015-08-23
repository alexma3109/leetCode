//record both the MAX & MIN, and the current max of max, focus on absolute value//
public class Solution {
    public int maxProduct(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return nums[0];
		}
		int max = nums[0];
		int min = nums[0];
		int res = nums[0];
		for(int i = 1 ; i < nums.length ; i++){
			int temp = max * nums[i];
			max = Math.max(Math.max(temp, nums[i]), min * nums[i]);
			min =Math.min(Math.min(temp, nums[i]), min * nums[i]);
			res = Math.max(res, max);
		}
		return res;
	}
}