class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        if(nums[low] < nums[high]) {
            return nums[low];
        }

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

// 3 4 5 1 2
/*
l - 0, h - 4

m - 2

3 < 5 -> l - m + 1 -> 3

l - 3 h - 4

m - 3

1 < 1 -> h - m -> 3
*/

/*

4 5 6 7 0 1 2

l - 0, h - 6

m - 3

n[l] < n[m] -> 4 < 7 -> l -> 4

l - 4, h - 6

m - 5

n[l] < n[m] -> 0 < 1 -> 
*/