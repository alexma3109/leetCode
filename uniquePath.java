public class Solution {
    public int uniquePaths(int m, int n) {
        if(m < 1 || n < 1){
	        return 0;
	    }   
	    if(m == 1 || n == 1){
	        return 1;
	    }

	    int[][] num = new int[m][n];
	    
    	for(int i = 0 ; i < m ; i++){
    	    num[i][0] = 1;
    	}
    	for(int j = 0 ; j < n ; j++){
    	    num[0][j] = 1;
    	}

    	for(int i = 1 ; i < m ; i++){
    	    for(int j = 1 ; j < n ; j++){
    	    	num[i][j] = num[i - 1][j] + num[i][j - 1];
    	    }	    
    	}
    	return num[m - 1][n - 1];        
    }
}