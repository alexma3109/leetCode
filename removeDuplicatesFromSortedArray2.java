public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3){
			return nums.length;
		}
		int index = 1;
		int count = 1;
		for(int i = 1 ; i < nums.length ; i++){
			if(nums[i] != nums[i - 1]){
				nums[index] = nums[i];
				index++;
				count = 1;
			}
			else if(count < 2){
				nums[index] = nums[i];
				count++;
				index++;
			}
			else{
				count++;
			}
		}
		return index;
    }
}