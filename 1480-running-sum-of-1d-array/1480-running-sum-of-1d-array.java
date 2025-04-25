class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int winSum = 0;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            winSum += nums[i];
            res[i] = winSum;
        }

        return res;
    }
}