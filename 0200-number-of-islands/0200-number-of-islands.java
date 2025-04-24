class Solution {
    int ROWS, COLS;

    public void dfs(char[][] grid, int row, int col) {
        if(row < 0 || row >= ROWS || col < 0 || col >= COLS || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
        dfs(grid, row - 1, col);

    }

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;  
        int count = 0;

        for(int i = 0; i < ROWS; i++ ) {
            for(int j = 0 ; j < COLS; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}