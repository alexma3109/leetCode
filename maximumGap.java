public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int num : nums){
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		int n = nums.length;
		int gap = (int)Math.ceil((double)(max - min) / (n - 1));
		int[] bucketMin = new int[n - 1];
		int[] bucketMax = new int[n - 1];
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);
		for(int num : nums){
			if(num != min && num != max){////max will not be in the last bucket////
				int i = (num - min) / gap;
				bucketMax[i] = Math.max(num, bucketMax[i]);
				bucketMin[i] = Math.min(num, bucketMin[i]);
			}			
		}
		int res = 0;
		int pre = min;
		for(int i = 0 ; i < n - 1 ; i++){
			if(bucketMax[i] != Integer.MIN_VALUE && bucketMin[i] != Integer.MAX_VALUE){
				res = Math.max(res, bucketMin[i] - pre);
				pre = bucketMax[i];	
			}			
		}
		res = Math.max(res, max - pre);
		return res;
    }
}