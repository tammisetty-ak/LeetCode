class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] rightCount = new int[26];
        int[] leftCount = new int[26];
        Arrays.fill(leftCount, -1);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (leftCount[s.charAt(i) - 'a'] == -1) {
                leftCount[s.charAt(i) - 'a'] = i;
            }

            rightCount[s.charAt(i) - 'a'] = i;
            ;
        }

        for (int i = 0; i < 26; i++) {

            if (leftCount[i] == -1) {
                continue;
            }

            HashSet<Character> btwn = new HashSet<>();

            for (int j = leftCount[i] + 1; j < rightCount[i]; j++) {
                btwn.add(s.charAt(j));
            }
            ans += btwn.size();
        }

        return ans;
    }
}