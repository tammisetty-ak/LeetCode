class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();

        backtracking(res, new StringBuilder(), 0, 0, n);

        return res;
    }

    private void backtracking(List<String> res, StringBuilder sb, int open, int close, int n) {
        if(sb.length() == n * 2) {
            res.add(sb.toString());
        }

        if(open < n) {
            sb.append("(");
            backtracking(res, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(close < open) {
            sb.append(")");
            backtracking(res, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}