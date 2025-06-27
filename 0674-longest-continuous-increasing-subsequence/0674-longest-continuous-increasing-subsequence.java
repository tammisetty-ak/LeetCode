class Solution {
    public int findLengthOfLCIS(int[] nums) {
        Integer candidate = -1;
        int count = 0;
        int maxCount = 0;
        for(int i : nums) {
            if(i > candidate) {
                count++;
                maxCount = Math.max(count, maxCount);
            }
            else {
                count = 1;
            }
            candidate = i;
        }

        return maxCount;
    }
}