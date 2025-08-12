class Solution {
    int ROWS, COLS;
    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int count = 0;
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        for(int d[] : dir) {
            int neighborRow = d[0] + i;
            int neighborCol = d[1] + j;

            if(neighborRow >= 0 && neighborCol < COLS && neighborCol >= 0 && neighborRow < ROWS && grid[neighborRow][neighborCol] == '1') {
                grid[neighborRow][neighborCol] = '0';
                dfs(neighborRow, neighborCol, grid);
            }
        }
    }
}