public class Solution {
    public int search(int[] nums, int target) {
        if(A == null || A.length == 0){
            return -1;
        }
		int start = 0;
		int end = nums.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(nums[mid] > nums[start]){
				if(target > nums[start] && target < nums[mid]){
					end = mid;
				}
				else{
					start = mid;
				}
			}
			else{
				if(nums[mid] < nums[end]){
					if(target > nums[mid] && target < nums[end]){
						start = mid;
					}
					else{
						end = mid;
					}
				}
			}
		}
		if(nums[start] == target){
			return start;
		}
		if(nums[end] == target){
			return end;
		}
		return -1;
    }
}