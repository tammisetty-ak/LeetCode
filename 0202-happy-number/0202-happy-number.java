class Solution {
    private static HashSet<Integer> set = new HashSet(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    private int getN(int n) {
        int d = 0, totalSum = 0;
        while(n > 0) {
            d = n % 10;
            totalSum += d * d;
            n = n / 10;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {

        while(n != 1 && !set.contains(n)) {
            n = getN(n);
        }

        return n == 1;
    }
}