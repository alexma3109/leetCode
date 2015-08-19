public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
    	if(matrix == null || matrix.length == 0){
        	return res;
        }
    	int n = matrix.length;
    	int m = matrix[0].length;
    	helper(res, matrix, 0, n, m);
    	return res;
    }
    public void helper(ArrayList<Integer> res, int[][] matrix, int k, int n, int m){
    	if(n - k * 2 <= 0 || m - k * 2 <= 0){
    		return;
    	}
    	if(n - k * 2 == 1){
        	for(int j = k; j < (m - k) ; j++){
        		res.add(matrix[k][j]);
        	}
    		return;
    	}
    	if(m - k * 2 == 1){
    		for(int i = k ; i < (n - k) ; i++){
        		res.add(matrix[i][k]);
    		}
    		return;
    	}
    	for(int j = k; j < (m - k) ; j++){
    		res.add(matrix[k][j]);
    	}
    	for(int i = k + 1; i < (n - k - 1) ; i++){
    		res.add(matrix[i][m - k - 1]);
    	}
        for(int j = (m - k - 1) ; j >= k ; j--){
        	res.add(matrix[n - k - 1][j]);
        }    		
        for(int i = (n - 2 - k) ; i >= k + 1 ; i--){
        	res.add(matrix[i][k]);
        }    		
    	helper(res, matrix, k + 1, n, m);        
    }
}