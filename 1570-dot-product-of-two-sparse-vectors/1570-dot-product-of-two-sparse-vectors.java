class SparseVector {

    HashMap<Integer, Integer> map = new HashMap();
    
    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
    // Determine which map is smaller to iterate over
    HashMap<Integer, Integer> smaller = this.map.size() < vec.map.size() ? this.map : vec.map;
    HashMap<Integer, Integer> larger = this.map.size() < vec.map.size() ? vec.map : this.map;

    int sum = 0;
    for (int key : smaller.keySet()) {
        if (larger.containsKey(key)) {
            sum += smaller.get(key) * larger.get(key);
        }
    }
    return sum;
}

}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);