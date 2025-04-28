class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        // Collections.reverse(Arrays.asList(nums));

        int n = nums.length;
        int i = 0, j = n-1;
        for(int p : nums)
            System.out.print(p + ",");

        int max = Integer.MIN_VALUE;

        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum >= k) {
                j--;
            }
            else {
                max = Math.max(sum, max);
                i++;
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}

// 34 23 1 24 75 33 54 8

// 1 8 23 24 33 34 54 75

// 75 54 34 33 24 23 8 1

// l + r >= k -> l++ r

// l + r < k -> queue, l++ r++