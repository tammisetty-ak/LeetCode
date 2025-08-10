class Solution {

    int max = 10000000;

    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        int[][] dp = new int[n][k];
        int[][] cost = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int median = houses[(i + j) / 2];
                int sum = 0;
                for(int l = i; l <= j; l++) {
                    sum += Math.abs(median - houses[l]);
                }
                cost[i][j] = sum;
            }
        }
        return solve(houses, 0, 0, k, dp, cost);
    }

    private int solve(int[] houses, int pos, int currK, int k, int[][] dp, int[][] cost) {
        if(pos == houses.length) {
            if(currK == k) {
                return 0;
            }
            else {
                return max;
            }
        }

        if(currK == k) {
            return max;
        }

        if(dp[pos][currK] != -1) {
            return dp[pos][currK];
        }
        
        int ans = max;

        for(int i = pos; i < houses.length; i++) {
            ans = Math.min(ans, solve(houses, i + 1, currK + 1, k, dp, cost) + cost[pos][i]);
        }
        dp[pos][currK] = ans;
        return ans;
    }
}