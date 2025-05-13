class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList();

        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }

        return res;
    }


    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int low = i + 1, high = nums.length - 1;

        while(low < high) {
            int sum = nums[low] + nums[high] + nums[i];

            if(sum < 0) {
                low++;
            }
            else if(sum > 0) {
                high--;
            }
            else {
                res.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                while(low < high && nums[low - 1] == nums[low]) {
                    low++;
                }
            }
        }
    }
} 

/*

1 -1 -1 0

-1 -1 0 1

i == 0

low = 1, high = 3

1 < 3

sum -> -1

-1 < 0
low++ -> 2

sum -> 0

res.add(-1 0 1)
3 < 3 

i == 1 

i-1 != i


i == 2

i-1 == i

low -> 3, high - 3

*/