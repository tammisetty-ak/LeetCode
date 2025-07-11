class Solution {
    int ROWS, COLS;
    int count;

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= ROWS || j >= COLS || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
    }

    public int numIslands(char[][] grid) {
        ROWS = grid.length; 
        COLS = grid[0].length;
        count = 0;

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}