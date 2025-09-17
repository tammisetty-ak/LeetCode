public class Solution {
    public int MaxArea(int[] height) {
        int left = 0, right = height.Length - 1;
        int maxW = 0;

        while(left < right) {
            maxW = Math.Max(maxW, (right - left )* Math.Min(height[left], height[right]));
            if(height[left] < height[right]) {
                left++;
            }
            else{
                right--;
            }
        }

        return maxW;
    }
}