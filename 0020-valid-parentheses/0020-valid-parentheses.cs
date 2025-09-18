public class Solution {
    public bool IsValid(string s) {
        Stack<char> stack = new Stack<char>();

        foreach(char c in s.ToCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.Push(c);
            }
            else if(c == ')') {
                if(stack.Count == 0 || stack.Pop() != '(') {
                    return false;
                }
            }
            else if(c == '}') {
                if(stack.Count == 0 || stack.Pop() != '{') {
                    return false;
                }
            }
            else if(c == ']') {
                if(stack.Count == 0 || stack.Pop() != '[') {
                    return false;
                }
            }
        }

        return stack.Count == 0;
    }
}