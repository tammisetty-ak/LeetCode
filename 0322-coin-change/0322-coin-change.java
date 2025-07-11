class Solution {

    private int findLowestCoins(int[] coins, int amount, int index, int[][] dp) {
        if(amount == 0) {
            return 0;
        }
        
        if(index == coins.length || amount < 0) {
            return Integer.MAX_VALUE - 1;
        }

        if(dp[index][amount] != -1) {
            return dp[index][amount];
        }
        
        int take = Integer.MAX_VALUE;
        if(coins[index] <= amount) {
            take = 1 + findLowestCoins(coins, amount - coins[index], index, dp);
        }
        int skip = findLowestCoins(coins, amount, index + 1, dp);

        return dp[index][amount] = Math.min(skip, take);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int res = findLowestCoins(coins, amount, 0, dp);
        return (res == Integer.MAX_VALUE - 1) ? -1 : res;
    }
}
