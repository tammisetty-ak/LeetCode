class Solution {
    int[][] dirs = new int[][] {
        { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
    };

    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        queue.offer(new int[] {0, 0, 0});

        int[][] minCost = new int[rows][cols];

        for(int row = 0; row < rows; row++) {
            Arrays.fill(minCost[row], Integer.MAX_VALUE);
        }

        minCost[0][0] = 0;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cost = curr[0], row = curr[1], col = curr[2];

            if(minCost[row][col] != cost) continue;

            for(int dir = 0; dir < 4; dir++) {
                int newRow = row + dirs[dir][0];
                int newCol = col + dirs[dir][1];

                if(
                    newRow >= 0 &&
                    newRow < rows && 
                    newCol >= 0 &&
                    newCol < cols
                ) {
                    int newCost = cost + (dir != (grid[row][col] - 1) ? 1 : 0);
                    if(minCost[newRow][newCol] > newCost) {
                        minCost[newRow][newCol] = newCost;
                        queue.offer(new int[] {newCost, newRow, newCol});
                    }
                }
            }
        }

        return minCost[rows - 1][cols - 1];
    }
}