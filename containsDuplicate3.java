public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		SortedSet<Long> set = new TreeSet<Long>();
		for(int i = 0 ; i < nums.length ; i++){
			long temp = (long) nums[i];
			SortedSet subset = set.subset(temp - t, temp + t + 1);
			if(!subset.isEmpty()){
				return true;
			}
			set.add(temp);
			if(i >= k){
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
}