class Solution {

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
        HashSet<Integer> set = new HashSet();

        while(n != 1 && !set.contains(n)) {
            set.add(n);
            n = getN(n);
        }

        return n == 1;
    }
}