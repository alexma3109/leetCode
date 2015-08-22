public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
		int n = nums2.length;
		if((m + n) % 2 == 0){
			return (helper(nums1, nums2, (m + n) / 2, 0, 0) + helper(nums1, nums2, (m + n) / 2 + 1, 0, 0)) / 2.0;
		}
		else{
			return helper(nums1, nums2, (m + n) / 2 + 1, 0, 0);
		}
    }
	public int helper(int[] nums1, int[]nums2, int k, int s1, int s2){
		if(s1 >= nums1.length){
			return nums2[s2 + k - 1];
		}
		if(s2 >= nums2.length){
			return nums1[s1 + k - 1];
		}
		if(k == 1){
			return Math.min(nums1[s1], nums2[s2]);
		}
		int key1 = s1 + k / 2 - 1 < nums1.length ? nums1[s1 + k / 2 - 1] : Integer.MAX_VALUE;
		int key2 = s2 + k / 2 - 1 < nums2.length ? nums2[s2 + k / 2 - 1] : Integer.MAX_VALUE;
		if(key1 > key2){
			return helper(nums1, nums2, k - k / 2, s1, s2 + k / 2);
		}
		else{
			return helper(nums1, nums2, k - k / 2, s1 + k / 2, s2);
		}
	}
}