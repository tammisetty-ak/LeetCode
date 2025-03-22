class Solution {

    private int ROWS;
    private int COLS;
    private int numOfIslands;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[ROWS - 1].length;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(i, j, grid);
                }
            }
        }
        return numOfIslands;
    }


    private void dfs(int row, int col, char[][] grid) {
        if(row < 0 || col < 0 || row >= ROWS || col >= COLS || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}