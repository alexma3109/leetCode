public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
		List<String> res = new ArrayList<String>();
		List<Integer> array = new ArrayList<Integer>();
		if(nums == null || nums.length == 0){
		    return res;
		}
		for(int i = 0 ; i < nums.length - 1 ; i++){
			array.add(nums[i]);
			if(nums[i + 1] == nums[i] + 1){
				continue;
			}
			else{
				temp.add(new ArrayList<Integer>(array));
				array.clear();
			}
		}
		array.add(nums[nums.length - 1]);
		temp.add(new ArrayList<Integer>(array));
		for(int i = 0 ; i < temp.size() ; i++){
			StringBuilder sb = new StringBuilder();			
			if(temp.get(i).size() > 1){
				sb.append(temp.get(i).get(0));
				sb.append("->");				
			}
			sb.append(temp.get(i).get(temp.get(i).size() - 1));
			res.add(sb.toString());
		}
		return res;    
    }
}