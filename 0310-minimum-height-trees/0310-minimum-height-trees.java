class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        var graph = new ArrayList<ArrayList<Integer>>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList();

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 1) {
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList();

        while(!queue.isEmpty()) {
            res = new ArrayList();

            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int node = queue.poll();
                res.add(node);
                for(int neighbor: graph.get(node)) {
                    if(--indegree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return res;
    }
}