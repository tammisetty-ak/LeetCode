class Solution {
    public int maxSumDivThree(int[] nums) {
        int min1a = Integer.MAX_VALUE, min1b = Integer.MAX_VALUE;
        int min2a = Integer.MAX_VALUE, min2b = Integer.MAX_VALUE;
        int sum = 0;

        for(int num : nums) {
            sum += num;
            if(num % 3 == 1) {
                if(num < min1a) {
                    min1b = min1a;
                    min1a = num;
                }
                else if(num < min1b) {
                    min1b = num;
                }
            }
            else if(num % 3 == 2) {
                if(num < min2a) {
                    min2b = min2a;
                    min2a = num;
                }
                else if(num < min2b) {
                    min2b = num;
                }
            }
        }

        if(sum % 3 == 0) {
            return sum;
        }
        
        if(sum % 3 == 1) {
            int op1 = min1a == Integer.MAX_VALUE ? 0 : sum - min1a;
            int op2 = min2a != Integer.MAX_VALUE && min2b != Integer.MAX_VALUE ? sum - min2a - min2b : 0;
            return Math.max(op1, op2);
        }
        else {
            int op1 = min1a != Integer.MAX_VALUE && min1b != Integer.MAX_VALUE ? sum - min1a - min1b : 0;
            int op2 = min2a == Integer.MAX_VALUE ? 0 : sum - min2a;
            return Math.max(op1, op2);
        }
    }
}