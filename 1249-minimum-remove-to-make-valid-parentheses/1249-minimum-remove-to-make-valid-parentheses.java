class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        
        // 1) First pass: mark invalid ')' for removal
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    // no matching '(', mark this ')' for removal
                    sb.setCharAt(i, '\0');
                } else {
                    stack.pop();  // matched one '('
                }
            }
        }
        
        // 2) Any indices left in stack are unmatched '(', mark them too
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '\0');
        }
        
        // 3) Build result without the marked chars
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c != '\0') {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
