class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i < dp.length; i++) {
            if(s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));

            if(twoDigit >= 10 && twoDigit < 27) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}