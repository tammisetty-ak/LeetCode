class Solution {

    int m;
    int n;
    int res;

    private int dfs(int i, int j, int[][] grid, int count) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        return (1 + dfs(i + 1, j, grid, count) + dfs(i - 1, j, grid, count) + dfs(i, j + 1, grid, count) + 
        dfs(i, j - 1, grid, count));
    }

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        res = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid, 0));
                }
            }
        }   

        return res; 
        
    }
}