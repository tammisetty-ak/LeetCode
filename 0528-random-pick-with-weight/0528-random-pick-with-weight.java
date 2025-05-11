class Solution {

    int totalSum;
    int[] prefixSums;

    public Solution(int[] w) {
        prefixSums = new int[w.length];
        int prefixSum = 0;
        for(int i = 0; i < w.length; i++) {
            prefixSum += w[i];
            prefixSums[i] = prefixSum;
        }

        totalSum = prefixSum;
    }
    
    public int pickIndex() {
        double target = totalSum * Math.random();

        int i = 0;
        for(; i < prefixSums.length; i++) {
            if(target < prefixSums[i]) {
                return i;
            }
        }
        return i - 1;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */