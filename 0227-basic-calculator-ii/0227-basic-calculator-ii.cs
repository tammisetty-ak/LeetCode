public class Solution {
    public int Calculate(string s) {
        int currNum = 0;
        char op = '+';

        var stack = new Stack<int>();

        for(int i = 0; i < s.Length; i++) {
            char c = s[i];
            if(char.IsDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            }
            if((!char.IsDigit(c) && c != ' ') || (i == s.Length - 1)) {
                switch(op) {
                    case '+' : stack.Push(currNum);
                    break;
                    case '-' : stack.Push(-currNum);
                    break;
                    case '*' : stack.Push(stack.Pop() * currNum);
                    break;
                    case '/' : stack.Push(stack.Pop() / currNum);
                    break;
                }
                op = c;
                currNum = 0;
            }
        }

        int res = 0;

        while(stack.Count != 0) {
            res += stack.Pop();
        }

        return res;
    }
}