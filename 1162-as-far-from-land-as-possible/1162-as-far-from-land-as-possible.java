class Solution {
    public int maxDistance(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int INF = rows + cols + 1;

        int[][] dp = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dp[i][j] != 0) {
                    if (i > 0) {
                        dp[i][j] = Math.min(1 + dp[i - 1][j], dp[i][j]);
                    }
                    if(j > 0) {
                        dp[i][j] = Math.min(1 + dp[i][j - 1], dp[i][j]);
                    }
                }
            }
        }

        for(int i = rows - 1; i >= 0; i--) {
            for(int j = cols - 1; j >= 0; j--) {
                if(dp[i][j] != 0) {
                    if(i < rows - 1) {
                        dp[i][j] = Math.min(1 + dp[i + 1][j], dp[i][j]);
                    }
                    if(j < cols - 1) {
                        dp[i][j] = Math.min(1 + dp[i][j + 1], dp[i][j]);
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0 && dp[i][j] != INF) {
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}