class Solution {
    public int findJudge(int n, int[][] trust) {

        int[][] graph = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(graph[i], 0);
        }

        for(int[] t : trust) {
            graph[t[0] - 1][t[1] - 1]++;
        }

        boolean canBeJudge = true;
        int count = 0;
        int isJudge = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] != 0) {
                    canBeJudge = false;
                }
            }
            if(canBeJudge) {
                count++;
                if(count > 1) {
                    return -1;
                }
                isJudge = i + 1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(isJudge == -1 || graph[i][isJudge - 1] == 0) {
                return -1;
            }
        }

        return isJudge;


       
    }
}