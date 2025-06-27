class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i: nums) {
            if(i != 1) {
                count = 0;
            }
            else {
                count++;
                maxCount = Math.max(count, maxCount);
            }
        }

        return maxCount;
    }
}