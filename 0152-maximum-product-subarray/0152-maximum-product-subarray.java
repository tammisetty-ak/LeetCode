class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int maxProd = 0;
        int minProd = 0;
        int res = maxProd;
        for(int i : nums) {
            int prod = Math.max(i, Math.max(maxProd * i, minProd * i));
            minProd = Math.min(i, Math.min(maxProd * i, minProd * i));
            maxProd = prod;
            res = Math.max(maxProd, res);
        }
        return res;
    }
}