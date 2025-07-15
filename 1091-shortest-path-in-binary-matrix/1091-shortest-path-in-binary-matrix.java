class Solution {

    private static final int[][] directions = new int[][] {
        {-1, -1},
        {-1, 0},
        {-1 , 1},
        {0, 1},
        {1, 1},
        {1, 0},
        {1, -1},
        {0, -1}
    };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList();
        grid[0][0] = 1;
        queue.add(new int[] {0, 0});


        while(!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int dist = grid[row][col];
            if(row == grid.length - 1 && col == grid[0].length - 1) {
                return dist;
            }

            for(int[] neighbor : getNeighbors(row, col, grid)) {
                queue.offer(neighbor);

                grid[neighbor[0]][neighbor[1]] = dist + 1;
            }
        }

        return -1;
    }

    private List<int[]> getNeighbors(int row, int col, int[][] grid) {
        List<int[]> neighbors = new ArrayList();

        for(int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbors.add(new int[]{ newRow, newCol});
        }

        return neighbors;
    }
}