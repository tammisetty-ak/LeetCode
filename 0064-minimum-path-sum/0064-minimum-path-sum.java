class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        for(int i = m; i >= 0; i--) {
            for(int j = n; j >= 0; j--) {
                if(i != m && j == n) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                }
                else if(i == m && j != n) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                }
                else if(i != m && j != n) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
                else {
                    dp[i][j] = grid[i][j];
                }
            }
        }

        return dp[0][0];
    }
}