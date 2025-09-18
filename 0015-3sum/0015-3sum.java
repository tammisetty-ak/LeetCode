class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();

        for(int i = 0; i < nums.length; i++) {
            if( i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }

        return res;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int low = i + 1, high = nums.length - 1;

        while(low < high) {
            int sum = nums[low] + nums[high] + nums[i];

            if(sum == 0) {
                res.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                while(low < high && nums[low - 1] == nums[low]) {
                    low++;
                }
            }
            else if(sum < 0) {
                low++;
            }
            else {
                high--;
            }
        }
    }
}
 