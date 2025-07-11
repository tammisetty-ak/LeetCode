class Solution {

    private int findLowestCoins(int[] coins, int amount, int index) {
        if(amount == 0) {
            return 0;
        }
        if(index == coins.length || amount < 0) {
            return Integer.MAX_VALUE - 1;
        }

        int take = Integer.MAX_VALUE;
        if(coins[index] <= amount) {
            take = 1 + findLowestCoins(coins, amount - coins[index], index);
        }
        int skip = findLowestCoins(coins, amount, index + 1);

        return Math.min(skip, take);
    }
    public int coinChange(int[] coins, int amount) {
        int res = findLowestCoins(coins, amount, 0);
        return (res == Integer.MAX_VALUE - 1) ? -1 : res;
    }
}
