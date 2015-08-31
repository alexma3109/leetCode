public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
		int right = height.length - 1;
		int pre = (right - left) * Math.min(height[left], height[right]);
		int cur = 0;
		while(left < right){
			if(height[left] < height[right]){
				left++;
			}
			else{
				right--;
			}
			cur = (right - left) * Math.min(height[left], height[right]);
			pre = Math.max(cur, pre);
		}
//		pre = Math.max(pre, (right - left) * Math.min(height[left], height[right]));
		return pre;
    }
}