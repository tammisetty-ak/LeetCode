class Solution {
    private int p1 = 0, p2 = 0;

    private int getMin(int nums1[], int nums2[]) {
        if(p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        else if (p1 < nums1.length) {
            return nums1[p1++];
        }
        else if (p2 < nums2.length) {
            return nums2[p2++];
        }
        return -1;
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        if((m + n) % 2 == 0) {
            for(int i = 0; i < (m + n) / 2 - 1; i++) {
                int tmp = getMin(nums1, nums2);
            }
            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        }   
        else {
            for(int i = 0; i < (m + n) / 2; i++) {
                int tmp = getMin(nums1, nums2);
            }
            return getMin(nums1, nums2);
        }
    }
}

/*

n1, n2

if nums1[n1 - 1] < nums2[0] {
    if((n1 == n2)) -> nums1[n1-1] + nums2[0] / 2 -> res

    if(n1 > n2) {
        return median(nums1);
    }
    else {
        return median (num2);
    }

}

else {
    int i = n1 - 1, j = 0
    int n = n1 + n2;
    int[] res = new int[n];
    while(nums[i] > nums[j]) {
        res[--n] = nums[i];

        i--;
        j++;
    }
}
*/