class Solution {
    private String resultString(String s) {
        Stack<Character> stack = new Stack();

        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && c == '#') {
                stack.pop();
            }
            else if(c != '#')
                stack.push(c);
        }
        StringBuilder res = new StringBuilder();
        
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
    public boolean backspaceCompare(String s, String t) {
        return resultString(s).equals(resultString(t));
    }
}