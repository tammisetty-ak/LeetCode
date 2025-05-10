class Solution {
    public long numberOfSubsequences(int[] nums) {
        long res = 0;

        Map<Double, Long> map = new HashMap<>();

        int n = nums.length;
        for(int r = n - 3; r >= 4; r--) {
            for(int s = r + 2; s < n; s++) {
                double rat = nums[r] / (double) nums[s];
                map.put(rat, map.getOrDefault(rat, 0L) + 1L);
            }

            int q = r - 2;
            for(int p = 0; p < q - 1; p++) {
                double rat = nums[q] / (double) nums[p];
                res += map.getOrDefault(rat, 0L);
            }
        }
        return res;
    }
}