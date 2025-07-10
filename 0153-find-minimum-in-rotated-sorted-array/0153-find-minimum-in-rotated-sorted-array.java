class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
            
        }

        return nums[low];
    }
}

// 4567012

// l - 0, h - 3
// m - 1

// 5 > a[l] 4 l - 2
// l - 2 h - 3
// m - 2
// 6 > 5 l - 3

// l - 3 h - 3
// m - 3
// 7 > 6
// l - 4


// 3 4 5 1 2

// l - 0 h - 5

// m - 2
// 5 > 3
// l = 4 h - 5

// m - 4


