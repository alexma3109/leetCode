public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
			for(int i = 0 ; i < n ; i++){
				nums1[i] = nums2[i];
			}
			return;
		}
		if(n == 0){
			return;
		}
		int i = m - 1, j = n - 1;
		for(int k = m + n ; k >= 0 ; k--){
			if(i < 0){
				nums1[k] = nums2[j];
				j--;
				continue;
			}
			if(j < 0){
				return;				
			}
			if(nums1[i] > nums2[j]){
				nums1[k] = nums1[i];
				i--;
			}
			else {
				nums1[k] = nums2[j];
				j--;
			}
		}
		return;
    }
}