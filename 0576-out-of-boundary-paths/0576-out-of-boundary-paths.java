class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove + 1][m][n];
        int MOD = 1000000007;

        dp[0][startRow][startColumn] = 1;
        int res = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for(int move = 1; move <= maxMove; move++) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(dp[move - 1][i][j] > 0) {
                        for(int d = 0; d < 4; d++) {
                                int ni = i + dx[d], nj = j + dy[d];
                                if(ni >= 0 && ni < m && nj >= 0 && nj < n) {
                                    dp[move][ni][nj] = (dp[move][ni][nj] + dp[move - 1][i][j]) % MOD;
                                }
                                else {
                                    res = (res + dp[move - 1][i][j]) % MOD;
                                }
                        }
                    }
                }
            }
        }

        return res;
    }
}