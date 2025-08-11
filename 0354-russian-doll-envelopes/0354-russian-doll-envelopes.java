class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                }
                else {
                    return Integer.compare(a[0], b[0]);
                }
            }
        });

        int n = envelopes.length;
        int[] secondDim = new int[n];
        for(int i = 0; i < n; i++) {
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
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }

        return sub.size();
    }

    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0, right = sub.size() - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(sub.get(mid) == num) {
                return mid;
            }
            else if(sub.get(mid) < num) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}