class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0, j = 1; i < prices.length && j < prices.length;) {
            if(prices[i] > prices[j]) {
                i = j;
            }
            else {
                profit = Math.max(profit, prices[j] - prices[i]);

            }
            if(j == prices.length) {
                i++;
                j = i + 1;
            }
            j++;
        }
        return profit;
    }
}