class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(String s, int startIndex, List<Integer> dots, List<String> ans) {
        final int remainingLength = s.length() - startIndex;
        final int remainingNoOfIntegers = 4 - dots.size();

        if(remainingLength > remainingNoOfIntegers * 3 || remainingLength < remainingNoOfIntegers) {
            return;
        }

        if(dots.size() == 3) {
            if(valid (s, startIndex, remainingLength)) {
                StringBuilder sb = new StringBuilder();
                int last = 0;
                for(Integer dot : dots) {
                    sb.append(s.substring(last, last + dot));
                    last += dot;
                    sb.append('.');
                }

                sb.append(s.substring(startIndex));
                ans.add(sb.toString());
            }
            return;
        }

        for(int currPos = 1; currPos <= 3 && currPos <= remainingLength; currPos++) {
            dots.add(currPos);
            if(valid(s, startIndex, currPos)) {
                helper(s, startIndex + currPos, dots, ans);
            }

            dots.remove(dots.size() - 1);
        }
    }

    private boolean valid(String s, int start, int length) {
        return (
            length == 1 || 
            (s.charAt(start) != '0' && 
            (length < 3 
                || s.substring(start, start + length).compareTo("255")<= 0)));
    }
}