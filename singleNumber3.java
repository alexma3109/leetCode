public class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0 ; i < nums.length ; i++){
			if(!set.contains(nums[i])){
				set.add(nums[i]);
			}
			else{
				set.remove(nums[i]);
			}
		}
		Iterator<Integer> iter = set.iterator();
		int[] res = new int[2];
		res[0] = iter.next();
		res[1] = iter.next();
		return res;
    }
}