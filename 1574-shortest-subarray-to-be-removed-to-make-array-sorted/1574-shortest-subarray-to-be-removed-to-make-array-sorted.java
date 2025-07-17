class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Step 1: Find longest non-decreasing prefix
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        if (left == n - 1) return 0; // Already sorted

        // Step 2: Find longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Step 3: Try removing entire prefix or suffix
        int result = Math.min(n - left - 1, right);

        // Step 4: Try merging prefix and suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
