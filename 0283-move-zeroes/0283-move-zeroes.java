class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length > 1) {
            int i = 0, j = 1;

            while (j < nums.length) {
                if (nums[i] == 0) {
                    // Move j to the next non-zero
                    while (j < nums.length && nums[j] == 0) {
                        j++;
                    }

                    // Only swap if j is still within bounds
                    if (j < nums.length) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                    }
                }

                // If current i is not zero, just move i forward
                // Else wait until we’ve done the swap, and then move
                if (nums[i] != 0) {
                    i++;
                } else if (j > i) {
                    i++;
                }

                // Always make sure j is ahead of i
                j = Math.max(j, i + 1);
            }
        }
    }
}
