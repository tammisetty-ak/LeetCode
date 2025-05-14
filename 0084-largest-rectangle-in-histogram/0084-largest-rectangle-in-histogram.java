class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            while((stack.peek()!=-1) && heights[i] <= heights[stack.peek()]) {
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                maxArea = Math.max(currHeight * currWidth, maxArea);
            }
            stack.push(i);
        }

        while(stack.peek() != -1) {
                int currHeight = heights[stack.pop()];
                int currWidth = n - stack.peek() - 1;
                maxArea = Math.max(currHeight * currWidth, maxArea);
        }

        return maxArea;
    }
}