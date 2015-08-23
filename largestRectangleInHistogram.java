public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for(int i = 0 ; i <= height.length ; i++){
			int cur = i == height.length ? -1 : height[i];
			while(!stack.isEmpty() && cur <= height[stack.peek()]){
				int h = height[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
			stack.push(i);
		}
		return max;
    }
}