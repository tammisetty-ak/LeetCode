class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        Arrays.fill(res, 1);

        for(int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int prod = 1;

        for(int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * prod;
            prod *= nums[i];
        }

        return res;
    }
}