class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;

        int left = 0, right = m;

        while(left <= right) {
            int partitionA = (m + n) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA1 = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightB1 = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
            int maxLeftA2 = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB2 = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if(maxLeftA1 < minRightB2 && maxLeftA2 < minRightB2) {
                if((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA1, maxLeftA2) + Math.min(minRightB1, minRightB2)) / 2.0;
                }
                else {
                    return Math.max(maxLeftA1, maxLeftA2);
                }
            }
            else if(maxLeftA1 > minRightB2) {
                right = partitionA - 1;
            }
            else {
                left = partitionA + 1;
            }
        }

        return 0.0;
    }
}