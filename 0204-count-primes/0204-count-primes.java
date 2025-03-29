class Solution {
    int[] arr;
    public int countPrimes(int n) {
        if(n < 2){ 
            return 0;
        }

        arr = new int[n];

        arr[0] = 1;
        arr[0] = 1;
        
        int count = 0;
        isPrime(n);
        for(int i = 2; i < n; i++) {
            if(arr[i] == 0){
                count++;
            }
        }

        return count;
    }

    private void isPrime(int n) {

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(arr[i] == 0) {
                for(int p = i * i; p < n; p += i) {
                    arr[p] = 1;
                }
            }
        }
    }
}