class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int res = 0;

        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            res++;
        }

        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res++;
            }
        }

        for(int df = 2; df < n; df++) {
            for(int i = 0; i < n - df; i++) {
                int j = i + df;

                if(s.charAt(j) == s.charAt(i) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}