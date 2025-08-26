class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double[] maxD = new double[3];
        maxD[0] = -1;

        for(int[] dim : dimensions) {
            double dia = sqrt(dim[0], dim[1]);
            int area = dim[0] * dim[1];

            if (dia > maxD[0] || (dia == maxD[0] && area > maxD[1] * maxD[2])) {
                maxD[0] = dia;
                maxD[1] = dim[0];
                maxD[2] = dim[1];
            }
        }

        return (int) (maxD[1] * maxD[2]);
    }

    private double sqrt(int len, int wid) {
        return Math.sqrt((len * len) + (wid * wid));
    }
}