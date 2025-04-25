class Solution {
    int k;

    public int[] getAverages(int[] nums, int k) {
        this.k = k;
        int n = nums.length;

        int winSum = 0;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (i >= k && i < n - k) {
                res[i] = calcRunningSum(nums, i);
                continue;
            }
            res[i] = -1;
        }
        return res;
    }

    public int calcRunningSum(int[] nums, int index) {
        long winSum = 0;
        for (int i = index - k; i <= index + k; i++) {
            winSum += nums[i];
        }
        return (int) (winSum / (2L * k + 1));
    }
}