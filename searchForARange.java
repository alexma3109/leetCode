public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
		int end = nums.length - 1;
		int[] res = new int[2];
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(target <= nums[mid]){
				end = mid;
			}
			else{
				start = mid;
			}
		}
		if(nums[start] == target){
			res[0] = start;
		}
		else if(nums[end] == target){
			res[0] = end;
		}
		else{
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		start = 0;
		end = nums.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(target < nums[mid]){
				end = mid;
			}
			else{
				start = mid;
			}			
		}
		if(nums[end] == target){
			res[1] = end;
		}
		else{
			res[1] = start;
		}
		return res;
    }
}