class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String token : tokens) {
            if("+-*/".contains(token)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch(token) {
                    case "+" : stack.push(op1 + op2);
                                break;
                    case "-" : stack.push(op1 - op2);
                                break;
                    case "*" : stack.push(op1 * op2);
                                break;
                    case "/" : stack.push(op1 / op2);
                                break;
                }
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}