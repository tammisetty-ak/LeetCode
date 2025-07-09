class Solution {
    public int[] findOriginalArray(int[] changed) {
        HashMap<Integer, Integer> map = new HashMap();
        Arrays.sort(changed);

        for(int i: changed) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[changed.length / 2];
        int index = 0;

        for(int num: changed) {
            if(map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                int twice = num * 2;
                if(map.containsKey(twice) && map.get(twice) > 0) {
                    map.put(twice, map.get(twice) - 1);
                    res[index++] = num;
                }
                else {
                    return new int[0];
                }
            }
        }

        return res;
    }
}