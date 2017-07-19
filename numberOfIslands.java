/* time: O(m * n), every char is visited twice at most, or only once */
/* space O(n), boolean[][] visited */

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    helper(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void helper(char[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        helper(grid, visited, i - 1, j);
        helper(grid, visited, i, j - 1);
        helper(grid, visited, i + 1, j);
        helper(grid, visited, i, j + 1);
    }
}