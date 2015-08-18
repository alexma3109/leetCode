public class Solution {
    public int trap(int[] A) {
        int[] left = new int[A.length];
		int[] right = new int[A.length];
		int max = 0;
		for(int i = 0 ; i < A.length ; i++){
			max = Math.max(A[i], max);
			left[i] = max;
		}
		max = 0;
		int res = 0;
		for(int i = A.length - 1 ; i >= 0 ; i--){
			max = Math.max(A[i], max);
			right[i] = max;
			left[i] = Math.min(left[i], right[i]);
			res += left[i] > A[i] ? left[i] - A[i] : 0;
		}
		return res;
    }
}