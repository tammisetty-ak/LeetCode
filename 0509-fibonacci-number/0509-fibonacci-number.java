class Solution {
    public int fib(int n) {
        if(n == 0) {
            return 0;
        }

        int res[] = new int[n + 1];
        res[1] = 1;
        for(int i = 2; i <= n; i++) {
            res[i] = res[i - 2] + res[i - 1];
        }

        return res[n];
    }
}