public class Solution {
    public int FirstMissingPositive(int[] nums) {
        int n = nums.Length;

        bool[] seen = new bool[n + 1];

        foreach(int num in nums) {
            if(num > 0 && num <= n)
                seen[num] = true;
        }


        for(int i = 1; i <= n; i++) {
            if(!seen[i]) {
                return i;
            }
        }

        return n + 1;
    }
}