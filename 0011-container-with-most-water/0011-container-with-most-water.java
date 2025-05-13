class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if(height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return maxArea;
    }
}

/*

[1,8,6,2,5,4,8,3,7]

len - 8

low - 0, high - 7

area -> min(nums[low], nums[high]) * (high - low)

if(nums[low] < nums[high]) {
    low++;
}
else {
    high--;
}

low - 1, high - 7
area -> min(nums[low], nums[high]) * (high - low) 
*/