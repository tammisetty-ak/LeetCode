class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        // queue -> [[0,0]]
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int minLapsed = 0;
        while (!queue.isEmpty()) {

            int len = queue.size();
            boolean rotten = false;
            while (len > 0) {
                Pair<Integer, Integer> pair = queue.poll();
                // [[]]
                int row = pair.getKey();
                int col = pair.getValue();
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];

                    if (neighborRow >= 0 && neighborRow < grid.length && neighborCol >= 0
                            && neighborCol < grid[0].length) {

                        if (grid[neighborRow][neighborCol] == 1) {
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            rotten = true;
                            queue.offer(new Pair(neighborRow, neighborCol));
                            // queue -> [[0,1] [1,0]]
                        }
                    }
                }
                len--;
            }
            if(rotten) minLapsed++;

        }

        return freshOranges == 0 ? minLapsed : -1;
    }
}