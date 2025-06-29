class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int count = 0;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        } // 0 1 2

        if(sum / k >= threshold) {
            count++;
        }

        for(int i = k; i < arr.length; i++) { // 3
            sum += (arr[i] - arr[i - k]);
            if(sum / k >= threshold) {
                count++;
            }
        }

        return count;

    }
}

/*

2 2 2 2 5 5 5 8

2 2 2 -> 6  2 == 4 X

2 2 2 -> 6 2 == 4 X

2 2 5 -> 9 3 == 4 X

2 5 5 -> 12 4 == 4 √

5 5 5 -> 15 5 >= 4 √

5 5 8 -> 18 6 >= 4 √

*/