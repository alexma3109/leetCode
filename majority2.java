public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
		int count2 = 0;
		int n1 = Integer.MIN_VALUE;
		int n2 = Integer.MIN_VALUE;
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i] == n1){
				count1++;
			}
			else if(nums[i] == n2){
				count2++;
			}
			else if(count1 == 0){
				n1 = nums[i];
				count1++;
			}
			else if(count2 == 0){
				n2 = nums[i];
				count2++;
			}
			else{
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i] == n1){
				count1++;
			}
			else if(nums[i] == n2){
				count2++;
			}
		}
		if(count1 > nums.length / 3){
			res.add(n1);
		}
		if(count2 > nums.length / 3){
			res.add(n2);
		}
		return res;
    }
}