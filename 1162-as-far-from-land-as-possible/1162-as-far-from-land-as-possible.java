class Solution {
    public int maxDistance(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int INF = rows + cols + 1;  // Max possible distance
        int[][] dp = new int[rows][cols];

        // Step 1: initialize DP array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = INF;
                }
            }
        }

        // Step 2: top-left to bottom-right pass
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] != 0) {
                    if (i > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }

        // Step 3: bottom-right to top-left pass
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (dp[i][j] != 0) {
                    if (i < rows - 1) dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    if (j < cols - 1) dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }

        // Step 4: get the max value
        int max = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && dp[i][j] != INF) {
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return (max == -1) ? -1 : max;
    }
}
