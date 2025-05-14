class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];

            while(!stack.isEmpty() && temperatures[stack.peek()] < currTemp) {
                int prevDay = stack.pop();
                ans[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

        return ans;
    }
}