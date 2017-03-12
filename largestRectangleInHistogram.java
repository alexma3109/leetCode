public class Solution {
    public int largestRectangleArea(int[] height) {
        int max = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0 ; i <= height.length ; i++){
        	/* always handle all the numbers before i */
        	/* i == length to handle the last one */
        	int cur = i == height.length ? -1 : height[i];
        	while(!deque.isEmpty() && cur <= height[deque.peek()]){
        		int h = height[deque.pop()];
        		int w = deque.isEmpty() ? i : i - deque.peek() - 1;
        		max = Math.max(max, h * w);
        	}
        	/* maintain an increase stack */
        	/* whenever meet smaller number, only consider the segment in stack, not include i */
        	/* h is always the pop out one */
        	/* w is the peek one till (i - 1) */
        	/* is stack is empty, then w is i */
        	deque.push(i);
        }
		return max;
    }
}