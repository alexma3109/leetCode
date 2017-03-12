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
    /* largest rectangle in histogram */
	public int helper(int[] height){
		int max = 0;
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i = 0 ; i <= height.length ; i++){
			int cur = i == height.length ? -1 : height[i];
			while(!deque.isEmpty() && cur <= height[deque.peek()]){
				int h = height[deque.pop()];
				int w = deque.isEmpty() ? i : i - deque.peek() - 1;
				max = Math.max(max, h * w);
			}
			deque.push(i);
		}
		return max;
	}
}