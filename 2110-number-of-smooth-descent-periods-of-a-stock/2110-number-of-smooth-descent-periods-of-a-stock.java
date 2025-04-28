class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 0;
        int left = 0, right = 0;
        int n = prices.length;

        while (right < n) {
            if (right > 0 && prices[right - 1] - prices[right] != 1) {
                left = right;
            }
            count += right++ - left + 1;
        }

        return count;
    }
}