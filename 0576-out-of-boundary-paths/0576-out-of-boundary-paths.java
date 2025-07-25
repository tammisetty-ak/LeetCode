class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int MOD = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] memo = new Integer[maxMove + 1][m][n];

        return findPathsHelper(m, n, maxMove, startRow, startColumn, memo);
    }

    private int findPathsHelper(int m, int n, int maxMove, int startRow, int startColumn, Integer[][][] memo) {
        if(startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            return 1;
        }

        if(maxMove == 0) {
            return 0;
        }

        if(memo[maxMove][startRow][startColumn] != null) {
            return memo[maxMove][startRow][startColumn];
        }

        int total = 0;
 
        for(int d = 0; d < 4; d++) {
            int nx = startRow + dx[d], ny = startColumn + dy[d];
            total = (total + findPathsHelper(m, n, maxMove - 1, nx, ny, memo)) % MOD;
        }

        memo[maxMove][startRow][startColumn] = total;

        return total;
    }
}