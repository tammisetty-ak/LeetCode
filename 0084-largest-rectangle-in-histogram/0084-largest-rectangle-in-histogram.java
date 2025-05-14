class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();

        stack.push(-1);
        
        int n = heights.length;

        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            while((stack.peek() != -1) && heights[stack.peek()] > heights[i]) {
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            stack.push(i);
        }

        while(stack.peek()!=-1){
            int currHeight = heights[stack.pop()];
            int currWidth = n - stack.peek() - 1;
            maxArea = Math.max(maxArea, currHeight * currWidth);
        }

        return maxArea;
    }
}