class Solution {
    private void backtrack(int[] nums, LinkedList<Integer> curr, List<List<Integer>> res) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!curr.contains(nums[i]))
            {
                curr.addLast(nums[i]);
                backtrack(nums, curr, res);
                curr.removeLast();
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        backtrack(nums, new LinkedList<Integer>(), res);
        return res;
    }
}