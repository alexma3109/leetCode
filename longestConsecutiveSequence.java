public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums){
			map.put(num, 0);
		}
		int max = 0;
		for(int num : nums){
			if(map.get(num) == 1){
				continue;
			}
			map.put(num, 1);
			int cur = 1;
			int index = num;
			while(map.containsKey(index + 1)){
				cur++;
				index++;
				map.put(index, 1);
			}
			index = num;
			while(map.containsKey(index - 1)){
				cur++;
				index--;
				map.put(index, 1);
			}
			max = Math.max(cur, max);
		}
		return max;        
    }
}