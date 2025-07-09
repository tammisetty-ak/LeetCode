class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 != 0) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        for(int num: changed) {
            max = Math.max(max, num);
        }


        int[] freq = new int[2 * max + 1];

        for(int num : changed) {
            freq[num]++;
        }
        int[] orig = new int[changed.length / 2];
        int index = 0;

        for(int i = 0; i <= max; i++) {
            if(freq[i] > 0) {
                freq[i]--;
                int twice = i * 2;

                if(freq[twice] > 0) {
                    freq[twice]--;
                    orig[index++] = i;
                    // i--;
                }
                else {
                    return new int[0];
                }
            }
        }
        return orig;
    }
}