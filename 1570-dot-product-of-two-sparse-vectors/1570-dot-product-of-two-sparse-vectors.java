class SparseVector {
    List<int[]> lst;

    SparseVector(int[] nums) {
        lst = new ArrayList();

        for(int i = 0; i < nums.length; i++) {
            lst.add(new int[]{i, nums[i]});
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i = 0, j = 0;
        int res = 0;
        while(i < lst.size() && j < vec.lst.size()) {
            res += lst.get(i)[1] * vec.lst.get(j)[1];
            i++;
            j++;
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);