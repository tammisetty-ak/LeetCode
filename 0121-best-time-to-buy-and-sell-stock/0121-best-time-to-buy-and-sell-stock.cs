public class Solution {
    public int MaxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for(int day = 1; day < prices.Length; day++) {
            if(buy > prices[day]) {
                buy = prices[day];
            }
            else {
                maxProfit = Math.Max(maxProfit, prices[day] - buy);
            }
        }

        return maxProfit;
    }
}