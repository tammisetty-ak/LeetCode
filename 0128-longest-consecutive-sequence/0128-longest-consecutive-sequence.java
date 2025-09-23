class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        HashMap<Integer, int[]> map = new HashMap();
        HashMap<Integer, Boolean> seen = new HashMap();

        for(int num : nums) {
            map.putIfAbsent(num, new int[]{num - 1, num + 1});
            seen.putIfAbsent(num, false);
        }

        int count = 1;

        Queue<Integer> queue = new LinkedList<>();
        int maxCount = 1;

        for(int num : nums) {
            queue.offer(num);
            count = 1;
            while(!queue.isEmpty()) {
                int temp = queue.poll();
                if(map.containsKey(temp) && !seen.get(temp)) {
                    for(int neighbor : map.get(temp)) {
                        if(map.containsKey(neighbor) && !seen.get(neighbor)) {
                            count++;
                            maxCount = Math.max(count, maxCount);
                            seen.put(temp, true);
                            queue.offer(neighbor);

                        }
                    }
                }
            }
        }
        return maxCount;
    }
}

// 4 [3, 5] c - 1
// 100 [99, 101] c - 1
//200 [199, 201] c - 1
//1 [0, 2] c - 1
//3 [2, 4] c - 1, c - 2
//2 [1, 3] c - 1 c - 2 c - 3 c - 4