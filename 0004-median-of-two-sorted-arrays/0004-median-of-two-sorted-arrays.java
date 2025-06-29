class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        int i = 0, j = 0, k = 0;
        int nums3[] = new int[m + n];

        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            }
            else {
                nums3[k++] = nums2[j++];
            }
        }
        
        while (i < m) {
            nums3[k++] = nums1[i++];
        }

        while(j < n) {
            nums3[k++] = nums2[j++];
        }

        return nums3.length % 2 != 0 ? nums3[(m + n) / 2] : (nums3[(m + n) / 2] + nums3[(m + n) / 2] - 1) / 2.0;
    }
}