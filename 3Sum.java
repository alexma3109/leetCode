public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length <= 2){
			return res;
		}
		for(int i = 0 ; i < nums.length - 2 ; i++){
			int j = i + 1, k = nums.length - 1;
			while(j < k){
				if(nums[j] + nums[k] + nums[i] == 0){
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					if(!res.contains(temp)){
						res.add(new ArrayList<Integer>(temp));
					}
					j++;
					k--;
				}
				else if(nums[j] + nums[k] + nums[i] > 0){
					k--;
				}
				else{
					j++;
				}
			}
		}
		return res;
    }
//******************answer******************************//	
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if(num == null || num.length < 3) {
			return rst;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}

			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right] + num[i];
				if (sum == 0) {
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[left]);
					tmp.add(num[right]);
					rst.add(tmp);
					left++;
					right--;
					while (left < right && num[left] == num[left - 1]) { // to skip duplicates
						left++;
					}
					while (left < right && num[right] == num[right + 1]) { // to skip duplicates
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return rst;
    }	
}