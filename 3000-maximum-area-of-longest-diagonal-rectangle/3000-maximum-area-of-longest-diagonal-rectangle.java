class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int[] maxD = new int[3]; 
        maxD[0] = -1; // squared diagonal
        maxD[1] = 0;  // length
        maxD[2] = 0;  // width

        for (int[] dim : dimensions) {
            int d2 = (dim[0] * dim[0]) + (dim[1] * dim[1]); // squared diagonal
            int area = dim[0] * dim[1];

            if (d2 > maxD[0] || (d2 == maxD[0] && area > maxD[1] * maxD[2])) {
                maxD[0] = d2;
                maxD[1] = dim[0];
                maxD[2] = dim[1];
            }
        }

        return maxD[1] * maxD[2];
    }
}
