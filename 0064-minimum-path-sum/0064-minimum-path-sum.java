class Solution {
    public int minPathSum(int[][] grid) {
        int len = grid.length, width = grid[0].length;

        int[][] dp = new int[len][width];

        for(int i = len - 1; i >= 0; i--) {
            for(int j = width - 1; j >= 0; j--) {
                if(i == len - 1 && j != width - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                }
                else if(i != len - 1 && j == width - 1) {
                    dp[i][j] =  grid[i][j] + dp[i + 1][j];
                }
                else if(i != len - 1 && j != width - 1) {
                    dp[i][j] = Math.min(grid[i][j] + dp[i + 1][j], grid[i][j] + dp[i][j + 1]);
                }
                else {
                    dp[i][j] = grid[i][j];
                }
            }
        }

        return dp[0][0];
    }
}