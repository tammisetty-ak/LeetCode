class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if(!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            else {
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
        }
        return stack.peek();

    }
}