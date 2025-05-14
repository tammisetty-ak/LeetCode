class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();

        backtracking(res, new StringBuilder(), 0, 0, n);

        return res;
    }

    private void backtracking(List<String> res, StringBuilder currString, int open, int closed, int n) {
        if(currString.length() == 2 * n) {
            res.add(currString.toString());
            return;
        }

        if(open < n) {
            currString.append("(");
            backtracking(res, currString, open + 1, closed, n);
            currString.deleteCharAt(currString.length() - 1);
        }

        if(closed < open) {
            currString.append(")");
            backtracking(res, currString, open, closed + 1, n);
            currString.deleteCharAt(currString.length() - 1);
        }
    }


} 