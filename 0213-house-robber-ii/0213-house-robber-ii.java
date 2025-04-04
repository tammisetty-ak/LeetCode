class Solution {

    private int findMaxRobbedAmount(int[] nums){
        int N = nums.length;

        int maxRobbedAmount[] = new int[N + 1];

        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N-1] = nums[N - 1];

        for(int i = N - 2; i >= 0; --i) {
            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i+1], maxRobbedAmount[i+2] + nums[i]);
        }

        return maxRobbedAmount[0];
    }

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] oneToLastButOne = new int[nums.length - 1];

        for(int i = 0; i < nums.length - 1; i++) {
            oneToLastButOne[i] = nums[i];
        }

        int[] twoToLast = new int[nums.length - 1];

        for(int i = 1; i < nums.length; i++) {
            twoToLast[i - 1] = nums[i];
        }
        return Math.max(findMaxRobbedAmount(oneToLastButOne), findMaxRobbedAmount(twoToLast));

        
    }
}