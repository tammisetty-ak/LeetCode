class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = 1;
        int currProfit = 0;
        while(j < prices.length) {
            if(prices[i] < prices[j]) {
                currProfit = Math.max(currProfit, prices[j] - prices[i]);
            }
            else {
                i = j;
            }           
            j++;
        }
        return currProfit;
    }
}