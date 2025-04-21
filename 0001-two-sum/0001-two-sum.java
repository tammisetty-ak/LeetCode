class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // [2,7,11,15], target = 9

        for(int i = 0; i < nums.length; i++) { // 2 // 7
            if(map.containsKey(target - nums[i])) { // 9 - 2 -> 7 // 9 - 7 -> 2

                return new int[]{map.get(target-nums[i]), i}; // 1, 0
            }
            map.put(nums[i], i); // 2 : 0, 
        }

        return new int[]{-1, -1};
    }
}