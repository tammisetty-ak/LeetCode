class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack();
        int strLength = s.length();
        int partLength = part.length();

        for(int index = 0; index < strLength; index++) {
            stack.push(s.charAt(index));

            if(stack.size() >= partLength && checkMatch(stack, part, partLength)) {
                for(int j = 0; j < partLength; j++) {
                    stack.pop();
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    private boolean checkMatch(Stack<Character> stack, String part, int partLength) {
        Stack<Character> temp = new Stack();

        temp.addAll(stack);

        for(int partIndex = partLength - 1; partIndex>=0 ; partIndex--) {
            if(temp.isEmpty() || temp.peek() != part.charAt(partIndex)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }
}