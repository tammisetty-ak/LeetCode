class Solution {
    int sum, prod;

    public boolean checkDivisibility(int n) {
        sum = 0;
        prod = 1;
        calcSumAndProd(n);
        return n % (sum + prod) == 0;
    }

    private void calcSumAndProd(int n) {
        while(n > 0) {
            sum += n % 10;
            prod *= n % 10;
            n = n / 10;
        }
    }
}