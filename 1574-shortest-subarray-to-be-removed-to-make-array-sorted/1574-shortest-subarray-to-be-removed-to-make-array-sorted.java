class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        for(; left < arr.length - 1; left++) {
            if(arr[left] > arr[left + 1]) {
                break;
            }
        }

        if(left == right) {
            return 0;
        }

        for(; right > 0; right--) {
            if(arr[right] < arr[right - 1]) {
                break;
            }
        }

        int result = Math.min(arr.length - left - 1, right);

        for(int i = 0, j = right; i <= left && j < arr.length; ) {
            if(arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            }
            else {
                j++;
            }
        }

        return result;
    }
}