class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int numDecodings(String s) {
        return recursiveMemo(0, s);
    }

    public int recursiveMemo(int index, String s) {
        if(memo.containsKey(index)) {
            return memo.get(index);
        }

        if(index == s.length()) {
            return 1;
        }
        
        if(s.charAt(index) == '0') {
            return 0;
        }

        if(index == s.length() - 1) {
            return 1;
        }

        int ans = recursiveMemo(index + 1, s);

        if(Integer.parseInt(s.substring(index, index + 1)) <= 26) {
            ans += recursiveMemo(index + 2, s);
        }

        memo.put(index, ans);
        return ans;
    }
}