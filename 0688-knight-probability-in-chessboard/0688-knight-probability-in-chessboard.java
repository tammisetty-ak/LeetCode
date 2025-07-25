class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
        int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};

        double[][][] dp = new double[k + 1][n][n];

        dp[0][row][column] = 1;

        for(int move = 1; move <= k; move++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dp[move - 1][i][j] > 0) {
                        for(int d = 0; d < 8; d++) {
                            int ni = i + dx[d], nj = j + dy[d];
                            if(ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[move][ni][nj] += dp[move - 1][i][j] / 8.0;
                            }
                        }
                    }
                }
            }
        }

        double probability = 0.0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                probability += dp[k][i][j];
            }
        }

        return probability;
    }
}