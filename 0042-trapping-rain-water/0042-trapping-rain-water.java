class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];

        for(int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];

        for(int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;

        for(int i = 0; i < height.length; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }
}
/*

4 2 0 3 2 5

4 4 4 4 4 5

5 5 5 5 5 5

0 2 4 1 2 0

*/