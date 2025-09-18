public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        Array.Sort(nums);
        List<IList<int>> res = new List<IList<int>>();
        for(int i = 0; i < nums.Length; i++) {
            if(i == 0 || nums[i - 1] != nums[i]) {
                TwoSum(nums, i, res);
            }
        }

        return res;
    }

    private void TwoSum(int[] nums, int i, List<IList<int>> res) {
        int lo = i + 1, hi = nums.Length - 1;
        while(lo < hi) {
            int sum = nums[lo] + nums[hi] + nums[i];
            if(sum == 0) {
                res.Add(new List<int>{nums[i], nums[lo], nums[hi]});
                lo++; hi--;
                while(lo < hi && nums[lo] == nums[lo - 1]) {
                    lo++;
                }
                while(lo < hi && nums[hi] == nums[hi + 1]) {
                    hi--;
                }
            }
            else if(sum > 0) {
                hi--;
            }
            else {
                lo++;
            }
        }
    }
}

//[-1,0,1,2,-1,-4]

// -4 -1 -1 0 1 2 

// 