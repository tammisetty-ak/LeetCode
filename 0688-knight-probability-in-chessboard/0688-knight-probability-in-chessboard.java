class Solution {
    int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};

    public double knightProbability(int n, int k, int row, int column) {
        Double memo[][][] = new Double[k + 1][n][n];

        return dfs(n, k, row, column, memo);
    }

    private double dfs(int n, int k, int row, int column, Double[][][] memo) {
        if(row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0;
        }

        if(k == 0) {
            return 1.0;
        }

        if(memo[k][row][column] != null) {
            return memo[k][row][column];
        }

        double prob = 0.0;

        for(int d = 0; d < 8; d++) {
            int ni = row + dx[d];
            int nj = column + dy[d];
            prob += dfs(n, k - 1, ni, nj, memo) / 8.0;
        }

        memo[k][row][column] = prob;

        return prob;
    }
}