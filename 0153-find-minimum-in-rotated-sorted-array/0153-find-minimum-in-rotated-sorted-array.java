class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;


        if(nums[low] < nums[high]) {
            return nums[low];
        }

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if(nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if(nums[mid] > nums[0]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
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


