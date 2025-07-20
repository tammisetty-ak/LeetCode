class Solution {
    public int minDistance(String word1, String word2) {
        return  minDistRecur(word1, word2, word1.length(), word2.length());
    }

    private int minDistRecur(String word1, String word2, int word1Index, int word2Index) {
        if(word1Index == 0) {
            return word2Index;
        }

        if(word2Index == 0) {
            return word1Index;
        }

        if(word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1)) {
            return minDistRecur(word1, word2, word1Index - 1, word2Index - 1);
        }
        else {
            int insertOp = minDistRecur(word1, word2, word1Index, word2Index - 1);
            int deleteOp = minDistRecur(word1, word2, word1Index - 1, word2Index);
            int replaceOp = minDistRecur(word1, word2, word1Index - 1, word2Index - 1);

            return Math.min(insertOp, Math.min(deleteOp, replaceOp)) + 1;
        }
    }
}