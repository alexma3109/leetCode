/* Q: What if the minSubArrayLen ? */

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); 
        // the sum from 0 to i is key, and i is value //
        for(int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            if(sum == k) {
                res = i + 1;
            }
            else if(map.containsKey(sum - k)) { 
            // if sum - x = k && x is in the map, //
            // then from x + 1 to i is what we need //
                res = Math.max(res, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)) { 
            // no need to update if it's existed in map //
            // the first is the longest range //
                map.put(sum, i);
            }
        }
        return res;
    }
}