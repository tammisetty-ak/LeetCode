class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for(int[] q: queries) {
            int L = q[0], R = q[1];
            diff[L] -= 1;
            // if(R + 1 < n) {
                diff[R + 1] += 1;
            // }
        }

        int running = 0;
        for(int i = 0; i < n; i++) {
            running += diff[i];
            if(nums[i] + running > 0) {
                return false;
            }
        }
        return true;
    }
}