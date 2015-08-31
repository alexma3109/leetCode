public class Solution {
    public int findMin(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        if(num.length == 1){
            return num[0];
        }
        int beg = 0;
    	int end = num.length - 1;
        while(beg < end - 1){
    		if(num[beg] < num[end]){
        		return num[beg];
    	    }
        	int mid = (beg + end) / 2;
	    	if((num[mid] > num[beg]) && (num[mid] > num[end])){
		        beg = mid;
    		    continue;
        	}
	    	if((num[mid] < num[beg]) && (num[mid] < num[end])){
		        end = mid;
    		    continue;
    	    }
	    }
        return Math.min(num[beg], num[end]);
    }
}