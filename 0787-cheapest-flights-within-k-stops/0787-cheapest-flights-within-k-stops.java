class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> graph = new HashMap();
        int stops = 0;
        int dist[] = new int[n];

        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], value -> new ArrayList()).add(new int[] { flight[1], flight[2] });
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList();

        queue.offer(new int[] { src, 0 });

        while (stops <= k && !queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int currNode = curr[0];
                int currPrice = curr[1];

                if (!graph.containsKey(currNode)) {
                    continue;
                }

                for (int[] neighborDetails : graph.get(currNode)) {
                    int neighborNode = neighborDetails[0];
                    int neighborPrice = neighborDetails[1];

                    if (neighborPrice + currPrice >= dist[neighborNode]) {
                        continue;
                    }

                    dist[neighborNode] = currPrice + neighborPrice;

                    queue.offer(new int[] { neighborNode, dist[neighborNode] });
                }
            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}