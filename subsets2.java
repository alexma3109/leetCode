public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(num.length < 1){
    		return res;
    	}
    	Arrays.sort(num);	
    	List<Integer> temp = new ArrayList<Integer>();
    	res.add(new ArrayList<Integer>(temp));
    	helper(0, res, temp, num);
    	return res;
    }
    public void helper(int pos, List<List<Integer>> res, List<Integer> temp, int[] num){
    	for(int i = pos ; i < num.length ; i++){
    		temp.add(num[i]);
    		if(!res.contains(temp)){
    			res.add(new ArrayList<Integer>(temp));
    		}
    		helper(i + 1, res, temp, num);
    		temp.remove(temp.size() - 1);
    	}     
    }
}
