class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "/", "*"));

        for(String token : tokens) {
            if(ops.contains(token)) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                switch (token) {
                    case "+" : stack.push(op2 + op1);
                                break;
                    case "-" : stack.push(op2 - op1);
                                break;
                    case "/" : stack.push(op2 / op1);
                                break;
                    case "*" : stack.push(op2 * op1);
                                break;
                }
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();

    }
}