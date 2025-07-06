class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        // First pass: Move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Second pass: Fill the remaining positions with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
