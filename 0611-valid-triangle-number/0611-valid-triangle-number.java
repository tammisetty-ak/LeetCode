class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++) {
            int k = i + 2;
            for(int j = i + 1; j < n - 1 && nums[i] != 0; j++){
                while(k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                    count += k - j - 1;
                }
            }
        }
        return count;
    }
}

/*
2 - 1
3 - 1
4 - 2
2 3 4 
2 3 4
2 4 4 
2 4 4

*/