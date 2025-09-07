class Solution {
    public int[] sumZero(int n) {
        int answer[] = new int[n];
        int index = 0;
        for(int i = 1; i <= n / 2; i++) {
            answer[index++] = i;
            answer[index++] = -i;
        }

        if(n%2 == 1) {
            answer[index] = 0;
        }
        return answer;
    }
}