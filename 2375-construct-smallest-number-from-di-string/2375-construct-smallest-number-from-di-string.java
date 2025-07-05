class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> stack = new Stack();

        for(int index = 0; index <= pattern.length(); index++) {
            stack.push(index + 1);
            if(index == pattern.length() || pattern.charAt(index) == 'I') {
                while(!stack.isEmpty()) {
                    res.append(stack.pop());
                }
            }
        }

        return res.toString();
    }
}