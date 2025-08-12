class Solution {
    int ROWS, COLS;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int count = 0;
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        if(i < 0 || j < 0 || i >= ROWS || j >= COLS || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
    }
}