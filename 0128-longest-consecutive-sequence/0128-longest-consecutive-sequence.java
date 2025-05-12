class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();

        for(int n: nums) {
            set.add(n);
        }

        int longStreak = 0;

        for(int n : nums) {
            if(!set.contains(n - 1)) {
                int currStreak = 1;
                while(set.contains(n + 1)) {
                    currStreak++;
                    n = n + 1;
                }

                longStreak = Math.max(longStreak, currStreak);
            }
        }

        return longStreak;
    }
}