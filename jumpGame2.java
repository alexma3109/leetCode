public class Solution {
//DP/////////////////////////////////////
    public int jump(int[] nums) {
        int[] res = new int[nums.length];
		res[0] = 0;
		for(int i = 1 ; i < nums.length ; i++){
			res[i] = Integer.MAX_VALUE;
			for(int j = 0 ; j < i ; j++){
				if(res[j] != Integer.MAX_VALUE && i - j <= nums[j]){
					res[i] = res[j] + 1;
					break;
				}
			}
		}
		return res[nums.length - 1];
    }
//greedy /////////////////////////////////////////
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }
}