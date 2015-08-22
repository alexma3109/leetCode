public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> prev = new ArrayList<Integer>();
    	prev.add(1);

    	if(rowIndex == 0){
    		return prev;
    	}

    	for(int i = 1 ; i <= rowIndex ; i++){
    		ArrayList<Integer> curr = new ArrayList<Integer>();
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
    	}
    	return prev;          
    }
}