class Solution {
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        Arrays.sort(coins);
        while(amount > 0){
            if(amount < coins[0]) {
                return -1;
            }
            for(int i = coins.length - 1; i >= 0; i--) {
                if(amount >= coins[i]) {
                    count += (amount / coins[i]);
                    amount = amount - ((amount / coins[i]) * coins[i]);
                }
            }
        }
        return count;
    }
}