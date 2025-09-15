import java.util.StringTokenizer;
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        StringTokenizer st = new StringTokenizer(text, " ");
        int count = 0;

        while(st.hasMoreTokens()) {
            String curr = st.nextToken();
            boolean broken = false;
            for(char c : brokenLetters.toCharArray()) {
                if(curr.indexOf(c) == -1) {
                    continue;
                }
                else {
                    broken = true;
                    break;
                }
            }
            if(!broken) {
                count++;
            }
        }

        return count;

    }
}