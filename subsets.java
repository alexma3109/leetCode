public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(nums.length < 1){
			return res;
		}
		Arrays.sort(nums);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		res.add(new ArrayList<Integer>(temp));
		helper(res, temp, nums, 0);
		return res;
    }
	
	public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] nums, int position){		
		for(int i = position ; i < nums.length ; i++){
			temp.add(nums[i]);
			if(!res.contains(temp)){
				res.add(new ArrayList<Integer>(temp));
			}
			helper(res, temp, nums, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}