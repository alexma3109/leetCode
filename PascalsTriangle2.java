public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(numRows == 0){
        	return res;
        }
    	List<Integer> prev = new ArrayList<Integer>();
    	prev.add(1);
    	res.add(new ArrayList<Integer>(prev));
    	if(numRows == 1){
    		return res;
    	}

    	for(int i = 2 ; i <= numRows ; i++){
    		List<Integer> curr = new ArrayList<Integer>();
    		for(int j = 0 ; j <= prev.size() ; j++){
    			if(j == 0){
    				curr.add(1);
    			}
    			else if(j == prev.size()){
    				curr.add(1);
    			}
    			else {
    				int sum = prev.get(j - 1) + prev.get(j);
    				curr.add(sum);
    			}
    		}
    		prev.clear();
    		for(int j = 0 ; j < curr.size() ; j++){
    			prev.add(curr.get(j));
    		}
    		curr.clear();
    		res.add(new ArrayList<Integer>(prev));
    	}
    	return res;        
    }
}