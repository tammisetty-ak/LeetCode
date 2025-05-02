class Solution {
    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int n: nums) {
            sum += n;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int out = Integer.MIN_VALUE;
        for(int i: nums) {
            int rem = sum - i;
            if(rem % 2 != 0) {
                continue;
            }
            map.put(i, map.getOrDefault(i, 0) - 1);
            int ele = rem / 2;
            if(map.getOrDefault(ele, 0) > 0) {
                out = Math.max(out, i);
            }
            map.put(i, map.get(i) + 1);
        }
        return out;
    }
}