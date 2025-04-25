class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        int[] res = new int[n];

        Arrays.fill(res, -1);

        int winSize = (2 * k) + 1;

        if(winSize > n) {
            return res;
        }

        int winSum = 0;

        for(int i = 0; i < winSize; i++) {
            winSum += nums[i];
        }
        res[k] = winSum / winSize;

        for(int i = k + 1; i < n - k; i++) {
            winSum = winSum + nums[i + k] - nums[i - k - 1];
            res[i] = winSum / winSize;
        }

        return res;
    }
}