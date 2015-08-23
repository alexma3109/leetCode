public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		int[] height = new int[n];
		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				if(matrix[i][j] == '1'){
					height[i][j]++;
				}
				else{
					height[i][j] = 0;
				}
			}
			max = Math.max(max, helper(height));
		}
		return max;
    }
	public int helper(int[] height){
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
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