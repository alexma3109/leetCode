public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] < target){
                left = mid;
            }
            else if(matrix[mid][0] > target){
                right = mid;
            }
            else{
                return true;
            }
        }
        if(target == matrix[left][0] || target == matrix[right][0]){
            return true;
        }
        if(left == 0 && target < matrix[left][0]){
            return false;
        }
        int row;
		if(target > matrix[right][0]){
            row = right;
        }
        else{
            row = left;
        }
        left = 0;
        right = matrix[0].length - 1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(target < matrix[row][mid]){
                right = mid;
            }
            else if(target > matrix[row][mid]){
                left = mid;
            }
            else{
                return true;
            }
        }
        if(target == matrix[row][left] || target == matrix[row][right]){
            return true;
        }
        return false;
    }
}