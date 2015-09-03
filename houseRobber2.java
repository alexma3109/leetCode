public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(nums, 0), helper(nums, 1));
    }
    public int helper(int[] nums, int start){
        int[] dp = new int[nums.length];
        if(start == 0){
            dp[0] = nums[0];
            dp[1] = nums[0];
            for(int i = 2 ; i < nums.length - 1 ; i++){
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            dp[nums.length - 1] = Math.max(dp[nums.length - 2], dp[nums.length - 3]);
        }
        else{
            dp[0] = 0;
            dp[1] = nums[1];
            for(int i = 2 ; i < nums.length ; i++){
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[nums.length - 1];
    }
}