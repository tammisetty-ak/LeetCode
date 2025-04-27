class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // int[] left = new int[n];
        // int[] right = new int[n];


        // left[0] = 1;
        // right[n-1] = 1;

        int[] ans = new int[n];

        ans[0] = 1;

        for(int i = 1; i < n; i++){
            ans[i] = nums[i-1] * ans[i-1];
        }
        
        int r = 1;

        for(int i = n - 1; i >= 0; i--){
            ans[i] = ans[i] * r;
            r *= nums[i];
        }

        return ans;
    }
}