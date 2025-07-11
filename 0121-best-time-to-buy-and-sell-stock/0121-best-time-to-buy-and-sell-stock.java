class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length ; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }

            else if(prices[i] - minPrice >= maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}

/*

7 1 5 3 6 4

mP - 0
i, j 

i - 0, j - 1

n[j] - n[i]  >= 0 
mp = mp, j - i

j++l


*/