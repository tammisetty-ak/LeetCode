class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int min1a = Integer.MAX_VALUE, min1b = Integer.MAX_VALUE;
        int min2a = Integer.MAX_VALUE, min2b = Integer.MAX_VALUE;

        
        for(int num : nums){
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
            sum += num;
        }

        if(sum % 3 == 0) {
            return sum;
        }

        else if(sum % 3 == 1) {
            int op1 = (min1a == Integer.MAX_VALUE) ? 0 : sum - min1a;
            int op2 = (min2a == Integer.MAX_VALUE && min2b == Integer.MAX_VALUE) ? 0 : sum - min2a - min2b;

            return Math.max(op1, op2);
        }

        else {
            int op1 = (min1a == Integer.MAX_VALUE) && min1b == Integer.MAX_VALUE ? 0 : sum - min1a  - min1b;
            int op2 = (min2a == Integer.MAX_VALUE) ? 0 : sum - min2a;
            return Math.max(op1, op2);
        }
    }
}


// 3 6 5 1 8 -> 23 % 3 -> 2

// 1 3 5 6 8 -> 1 5 8 -> 23 - max(5, 8) -> 18

// 4 -> 4 -> 1

// 4 -> 4

// 1 2 3 4 4 -> 12 -> 

// 1 2 3 4 4 -> 1 2 4 -> 8 10