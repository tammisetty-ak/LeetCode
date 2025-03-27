class Solution {
    public int countPrimes(int n) {

        if(n < 2){
            return 0;
        }

        boolean[] numbers = new boolean[n];

        Arrays.fill(numbers, true);
        numbers[0] = false;
        numbers[1] = false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(numbers[i] == true) {
                for(int p = i * i; p < n; p += i) {
                    numbers[p] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < numbers.length; i++) {
            if(numbers[i]) {
                count++;
            }
        }

        return count;
    }
}