class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    int[][][] memo = new int[m][n][maxMove + 1];
    for (int[][] layer : memo)
        for (int[] row : layer)
            Arrays.fill(row, -1);
    return dfs(m, n, maxMove, startRow, startColumn, memo);
}

private int dfs(int m, int n, int moves, int i, int j, int[][][] memo) {
    if (i < 0 || i >= m || j < 0 || j >= n) return 1;
    if (moves == 0) return 0;
    if (memo[i][j][moves] != -1) return memo[i][j][moves];

    int res = 0, MOD = 1000000007;
    res = (res + dfs(m, n, moves - 1, i - 1, j, memo)) % MOD;
    res = (res + dfs(m, n, moves - 1, i + 1, j, memo)) % MOD;
    res = (res + dfs(m, n, moves - 1, i, j - 1, memo)) % MOD;
    res = (res + dfs(m, n, moves - 1, i, j + 1, memo)) % MOD;

    memo[i][j][moves] = res;
    return res;
}

}
