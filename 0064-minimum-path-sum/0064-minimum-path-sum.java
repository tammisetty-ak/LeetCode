class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];


        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j != n - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                }
                else if(i != m - 1 && j == n - 1) {
                    dp[j] = grid[i][j] + dp[j];
                }
                else if(i != m - 1 && j != n - 1) {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                }
                else {
                    dp[j] = grid[i][j];
                }
            }
        }

        return dp[0];
    }
}