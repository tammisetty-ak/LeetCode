class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] dp = new int[rows][cols];
        int INF = rows + cols + 1;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(mat[i][j] == 1) {
                    dp[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dp[i][j] != 0) {
                    if(i > 0) {
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

        return dp;
    }
}