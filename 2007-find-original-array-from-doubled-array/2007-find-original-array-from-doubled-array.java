class Solution {
    public int[] findOriginalArray(int[] changed) {

        if(changed.length % 2 == 1) {
            return new int[]{};
        }        
        
        int n = changed.length / 2;


        Arrays.sort(changed);
        Map<Integer, Integer> freq = new HashMap();

        for(int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] original = new int[n];
        int i = 0;

        for(int num : changed) {
            if(freq.get(num) > 0) {
                freq.put(num, freq.get(num) - 1);
                int twiceNum = num * 2;

                if(freq.containsKey(twiceNum) && freq.get(twiceNum) > 0) {
                    freq.put(twiceNum, freq.get(twiceNum) - 1);
                    original[i++] = num;
                }
                else {
                    return new int[0];
                }
            }
        }
        return original;
    }
}