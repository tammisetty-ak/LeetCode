class Solution {
    public String largestGoodInteger(String num) {
        int max = Integer.MIN_VALUE;

        StringBuilder res = new StringBuilder();
        
        for(int i = 0; (i + 2) < num.length() ; i++) {
            if(num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                if(Integer.parseInt(num.substring(i, i + 3)) > max) {
                    res.setLength(0);
                    res.append(num.substring(i, i + 3));
                    max = Integer.parseInt(num.substring(i, i + 3));
                }
            }
        }

       return max == Integer.MIN_VALUE ? "" : res.toString();
    }
}