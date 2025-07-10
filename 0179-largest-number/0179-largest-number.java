class Solution {
    public String largestNumber(int[] nums) {
        String[] numString = new String[nums.length];

        int i = 0;

        for(int num : nums) {
            numString[i++] = String.valueOf(num);
        }

        Arrays.sort(numString, (a, b) -> (b + a).compareTo(a + b));

        if(Integer.valueOf(numString[0]) == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();

        for(String numStr : numString) {
            res.append(numStr);
        }

        return res.toString();
    }
}

// a - 3 b - 30

// a + b -> 330

// b + a -> 303 

// 330 > 303 == 1 -> 3 30

// 303 > 330 == -1 -> 3 30
