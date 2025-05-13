class Solution {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;

        int n = height.length;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        maxRight[n - 1] = height[n - 1];
        for (int r = n - 2; r >= 0; r--) {
            maxRight[r] = Math.max(maxRight[r + 1], height[r]);
        }

        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            count += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return count;

    }
}