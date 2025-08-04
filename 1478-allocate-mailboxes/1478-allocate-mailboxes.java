class Solution {
    int MAX = 10000000;

    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        int[][] dp = new int[n][k];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return solve(houses, k, 0, 0, dp);
    }


    public int solve(int[] houses, int k, int pos, int curK, int[][] dp) {
        if(pos == houses.length) {
            if(curK == k) {
                return 0;
            }

            return MAX;
        }

        if(curK == k) {
            return MAX;
        }

        if(dp[pos][curK] != -1) {
            return dp[pos][curK];
        }

        int answer = MAX;
        for(int i = pos; i < houses.length; i++) {
            int median = houses[(i + pos) / 2];

            int cost = 0;
            for(int j = pos; j <= i; j++) {
                cost += Math.abs(median - houses[j]);
            }

            answer = Math.min(answer, solve(houses, k, i + 1, curK + 1, dp) + cost);
        }

        dp[pos][curK] = answer;
        return answer;
    }
}