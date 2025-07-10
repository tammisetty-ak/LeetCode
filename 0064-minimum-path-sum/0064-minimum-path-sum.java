class Solution {
    public int minPathSum(int[][] grid) {
        int len = grid.length, width = grid[0].length;

        int[] dp = new int[width];

        for(int i = len - 1; i >= 0; i--) {
            for(int j = width - 1; j >= 0; j--) {
                if(i == len - 1 && j != width - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                }
                else if(i != len - 1 && j == width - 1) {
                    dp[j] =  grid[i][j] + dp[j];
                }
                else if(i != len - 1 && j != width - 1) {
                    dp[j] = Math.min(grid[i][j] + dp[j], grid[i][j] + dp[j + 1]);
                }
                else {
                    dp[j] = grid[i][j];
                }
            }
        }

        return dp[0];
    }
}