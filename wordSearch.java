public class Solution {
    public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean[][] flag = new boolean[m][n];
		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				if(board[i][j].equals(word.charAt(0))){
					if(helper(board, i, j, word, flag, 0)){
						return true;
					}
				}
			}
		}
		return false;
    }
	public boolean helper(char[][] board, int i, int j, String word, boolean[][] flag, int pos){
		if(pos == word.length()){
			return true;
		}
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
			return false;
		}
		if(!flag[i][j] && board[i][j] == word.charAt(pos)){
			flag[i][j] = true;
			if(helper(board, i + 1, j, word, flag, pos + 1)){
				return true;
			}
			if(helper(board, i, j + 1, word, flag, pos + 1)){
				return true;
			}
			if(helper(board, i - 1, j, word, flag, pos + 1)){
				return true;
			}
			if(helper(board, i, j - 1, word, flag, pos + 1)){
				return true;
			}
			flag[i][j] = false;
		}
		return false;
	}
}

