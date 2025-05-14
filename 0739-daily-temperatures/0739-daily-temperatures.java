class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;

        int ans[] = new int[len];
        Stack<Integer> stack = new Stack();

        for(int currDay = 0; currDay < len; currDay++) {
            int currTemp = temperatures[currDay];

            while(!stack.isEmpty() && temperatures[stack.peek()] < currTemp) {
                int prevDay = stack.pop();
                ans[prevDay] = currDay - prevDay;
            }

            stack.push(currDay);
        }

        return ans;
    }
}