class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]> () {
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0] == arr2[0]) {
                    return Integer.compare(arr2[1], arr1[1]);
                }
                else {
                    return Integer.compare(arr1[0], arr2[0]);
                }
            }
        });

        int[] secondDim = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++) {
            secondDim[i] = envelopes[i][1];
        }

        return LIS(secondDim);
    }

    private int LIS(int[] secondDim) {
        int n = secondDim.length;
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(secondDim[0]);

        
        for(int i = 1; i < n; i++) {
            int num = secondDim[i];
            if(num > sub.get(sub.size() - 1)) {
                sub.add(num);
            }
            else {
                int j = 0;
                while(sub.get(j) < num) {
                    j++;
                }
                sub.set(j, num);
            }
        }

        return sub.size();
    }
}