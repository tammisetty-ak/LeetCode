class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int prod = 1;

        for(int i = n - 1; i >= 0; i--) {
            res[i] = prod * res[i];
            prod *= nums[i];
        }

        return res;
    }
}

// 1 2 3 4

// res -> 1 1 2 6


// res[0] = 1
// res[1] = res[0] * nums[0]
// res[2] = res[1] * nums[1]
// res[3] = res[2] * nums[2]


//         res[i] = res[i-1] * nums[i-1]

// nums -> 1 2 3 4
// res -> 1 1 2 6


// i -> n - 1

// prod - 1

// res[i - 1] = prod * res[i-1] 
// prod *= nums[i]