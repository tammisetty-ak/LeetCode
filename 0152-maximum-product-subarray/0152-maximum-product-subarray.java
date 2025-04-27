class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int res = maxProd;

        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int prod = Math.max(curr, Math.max(maxProd * curr, minProd * curr));
            minProd = Math.min(curr, Math.min(maxProd* curr, minProd * curr));
            maxProd = prod;

            res = Math.max(res, maxProd);
        }

        return res;
    }
}