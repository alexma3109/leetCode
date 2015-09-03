////keep a decreasing LinkedList, remove old tail if new num is larger, remove head if length exceeds,
////fill in res[] when i + 1 >= k, always take the head.
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int[] res = new int[nums.length - k + 1];
		for(int i = 0 ; i < nums.length ; i++){
			while(!list.isEmpty() && nums[i] >= num[list.getLast()]){
				list.removeLast();
			}
			list.addLast(i);
			if(i - list.getFirst() + 1 > k){
				list.removeFirst();
			}
			if(i + 1 >= k){
				res[i - k + 1] = nums[list.getFirst()];
			}
		}
		return res;
	}
}