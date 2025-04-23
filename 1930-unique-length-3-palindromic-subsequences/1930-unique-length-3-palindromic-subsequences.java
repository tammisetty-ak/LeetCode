class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Set<String> res = new HashSet<>();
        int[] rightCount = new int[26];
        int[] leftCount = new int[26];

        for(int i = 0; i < n; i++) {
            rightCount[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < n; i++) {
            char center = s.charAt(i);
            rightCount[center - 'a']--;
            for(int j = 0; j < 26; j++) {
                if(rightCount[j] > 0 && leftCount[j] > 0) {
                    String str = "" + (char)(j + 'a') + center + (char)(j + 'a') ;
                    res.add(str);
                }
            }
            leftCount[center - 'a']++;
        }

        return res.size();
    }
}