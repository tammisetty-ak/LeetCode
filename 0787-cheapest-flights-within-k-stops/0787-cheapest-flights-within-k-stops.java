class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for(int[] i : flights) {
            graph.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[]{i[1], i[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{src, 0});
        int stops = 0;

        while(stops <= k && !queue.isEmpty()) {
            int sz = queue.size();
            while(sz-- > 0) {
                int[] temp = queue.poll();
                int node = temp[0];
                int distance = temp[1];

                if(!graph.containsKey(node)) {
                    continue;
                }

                for(int[] neighbor : graph.get(node)) {
                    int neigh = neighbor[0];
                    int price = neighbor[1];
                    if(price + distance >= dist[neigh]) {
                        continue;
                    }
                    dist[neigh] = price + distance;
                    queue.offer(new int[] {neigh, dist[neigh]});
                }
            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}