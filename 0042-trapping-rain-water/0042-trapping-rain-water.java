class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0, ans = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                left_max = Math.max(height[left], left_max);
                ans += left_max - height[left];
                left++;
            }
            else {
                right_max = Math.max(height[right], right_max);
                ans += right_max - height[right];
                right--;
            }
        }
        return ans;
    }
}