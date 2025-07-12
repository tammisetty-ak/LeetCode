class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack();

        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && c == '*') {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        for(char c: stack) {
            res.append(c);
        }

        return res.toString();
    }
}