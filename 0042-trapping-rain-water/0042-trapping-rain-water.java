class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];

        for(int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        for(int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int res = 0;
        for(int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }
}

// leftMax -> 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3
// rightMax -> 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3

// res += Min(leftMax, rightMax) - height[i];