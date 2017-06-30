public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A.length == 0 || A[0].length == 0 || B[0].length == 0) {
            return null;
        }
        int m = A.length, n = A[0].length, l = B[0].length;
        int[][] res = new int[m][l];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(A[i][j] != 0) { // check wether A[i][j] == 0 //
                    for(int k = 0 ; k < l ; k++) {
                        if(B[j][k] != 0) { // check wether B[j][k] == 0 //
                            res[i][k] += A[i][j] * B[j][k];
                        }
                    }                    
                }
            }
        }
        return res;
    }
}