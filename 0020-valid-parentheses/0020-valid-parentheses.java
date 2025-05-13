class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char removed = stack.pop();
                if ((c == '}' && removed != '{') || (c == ']' && removed != '[') || (c == ')' && removed != '(')) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}