class Solution {

    int max = 10000000;

    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        int[][] dp = new int[n][k];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(houses, 0, 0, k, dp);
    }

    private int solve(int[] houses, int pos, int currK, int k, int[][] dp) {
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
            int median = houses[(i + pos) / 2];
            int cost = 0;
            for(int j = pos; j <= i; j++) {
                cost += Math.abs(houses[j] - median);
            }

            ans = Math.min(ans, solve(houses, i + 1, currK + 1, k, dp) + cost);
        }
        dp[pos][currK] = ans;
        return ans;
    }
}