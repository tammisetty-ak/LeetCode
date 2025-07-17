class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long[] leftSum = new long[n];
        long[] rightSum = new long[n];

        Deque<Integer> stack = new ArrayDeque<>();
        long sum = 0;

        // Left pass
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }

            int j = stack.isEmpty() ? -1 : stack.peek();
            int len = i - j;

            leftSum[i] = (j == -1 ? 0 : leftSum[j]) + 1L * len * heights[i];
            stack.push(i);
        }

        stack.clear();

        // Right pass
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }

            int j = stack.isEmpty() ? n : stack.peek();
            int len = j - i;

            rightSum[i] = (j == n ? 0 : rightSum[j]) + 1L * len * heights[i];
            stack.push(i);
        }

        // Find max
        long max = 0;
        for (int i = 0; i < n; i++) {
            long total = leftSum[i] + rightSum[i] - heights[i];
            max = Math.max(max, total);
        }

        return max;
    }
}
