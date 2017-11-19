/* 3 pointers, left, index, right */
/* index scan from 0 to 'right' */
/* index from 0, whenever left++, index++ */
/* because it will be handled when left comes */
/* right--, index stay */
/* time O(n) */

public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
		int right = nums.length - 1;
		int pointer = 0;
		while(pointer <= right){
			if(nums[pointer] == 0){
				swap(nums, pointer, left);
				left++;
				pointer++;
			}
			else if(nums[pointer] == 1){
				pointer++;
			}
			else{
				swap(nums, pointer, right);
				right--;
			}
		}
    }
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}