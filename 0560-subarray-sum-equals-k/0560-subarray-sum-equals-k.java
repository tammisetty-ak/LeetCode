class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();

        map.put(0, 1);
        int sum = 0, count = 0;
        for(int num : nums) {
            sum += num;

            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

/*

prev - nums[0]
int count = 0;

for(int i = 1; i < nums.length; i++) {
    if(prev == k) {
        count++;
    }
    prev += nums[i];
}

prev - 1
count - 0

prev> 
2 == 2
count - 1

prev - 3
*/