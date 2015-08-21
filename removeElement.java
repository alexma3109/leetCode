public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
		int right = nums.length - 1;
		int left = 0;
		while(left < right){
			if(nums[right] == val){
				right--;
				continue;
			}
			if(nums[left] != val){
				left++;
				continue;
			}
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
		}
		if(nums[left] == val){
			return left;
		}
		else{
			return left + 1;
		}
    }
}