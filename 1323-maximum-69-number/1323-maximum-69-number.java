class Solution {
    public int maximum69Number (int num) {
        String numString = String.valueOf(num);

        StringBuilder sb = new StringBuilder();
        int i = 0;

        for(; i < numString.length(); i++) {
            if(numString.charAt(i) == '6') {
                sb.append('9');
                i++;
                break;
            }
            sb.append(numString.charAt(i));
        }

        if(i < numString.length()) {
            sb.insert(i, numString.substring(i, numString.length()));
        }

        return Integer.valueOf(sb.toString());
    }
}