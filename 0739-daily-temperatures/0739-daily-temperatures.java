class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int currDay = 0; currDay < n; currDay++) {
            int currTemp = temperatures[currDay];
            while(!stack.isEmpty() && temperatures[stack.peek()] < currTemp){
                int prevDay = stack.pop();
                ans[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }

        return ans;
    }
}