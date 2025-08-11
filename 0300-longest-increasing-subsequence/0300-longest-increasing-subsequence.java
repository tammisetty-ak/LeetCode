class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i = 1; i < n; i++) {
            int num = nums[i];

            if(num > sub.get(sub.size() - 1)) {
                sub.add(num);
            }
            else {
                int j = 0;
                while(num > sub.get(j)) {
                    j += 1;
                }

                sub.set(j, num);
            }
        }
        return sub.size();
    }
}