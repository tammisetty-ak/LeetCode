class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            int len = queue.size();
            boolean rotten = false;
            while(len-- > 0) {
                int[] pair = queue.poll();

                int row = pair[0];
                int col = pair[1];

                for(int[] d : directions) {
                    int neighborRow = d[0] + row;
                    int neighborCol = d[1] + col;

                    if(neighborRow >= 0 && neighborRow < m && neighborCol >= 0 && neighborCol < n) {
                        if(grid[neighborRow][neighborCol] == 1) {
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            rotten = true;
                            queue.offer(new int[]{neighborRow, neighborCol});
                        }
                    }

                }
            }
            if(rotten)
                    minutes++;
        }
        return freshOranges != 0 ? -1 : minutes;
    }
}