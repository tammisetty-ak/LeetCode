class Solution {
    public int numDecodings(String s) {
        // 1224

        // a b b d
        // l b d
        // a v d
        // a b x

        int n = s.length();
        int[] dp = new int[n + 1];
        
        if(s.charAt(0) == '0') {
            return 0;
        }

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 1; i < n; i++) {
            if(s.charAt(i) != '0'){
                dp[i + 1] += dp[i];
            }

            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));

            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }

        return dp[n];
    }
}