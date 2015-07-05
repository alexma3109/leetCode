public class Solution {
    public int removeDuplicates(int[] nums) {
		if(nums.length < 2){
			return nums.length;
		}
		int pre = nums[0];
		int i, j;
		for(i = 1, j = 1; i < nums.length ; i++){
			if(pre < nums[i]){
				nums[j] = nums[i];
				j++;
				pre = nums[i];
			}
		}
		return j;
    }
}