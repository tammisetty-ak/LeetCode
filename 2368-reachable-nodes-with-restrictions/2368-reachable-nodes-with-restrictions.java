class Solution {
    int[] visited;
    ArrayList<Integer>[] graph;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        graph = new ArrayList[n];
        visited = new int[n];

        for(int i : restricted) {
            visited[i] = -1;
        }

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }

        for(int edge[] : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] count = new int[1];
        dfs(0, count);
        return count[0];
    }

    private void dfs(int node, int[] count) {
        if(visited[node] != 0) {
            return;
        }

        visited[node] = 1;
        count[0]++;

        for(int neighbor : graph[node]) {
            dfs(neighbor, count);
        }

    }
}

// edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]]

// 0 -> 1, 4, 5

// 1 -> 2

// 2 -> // 3 -> 1 // 4 -> 0 // 5 -> 6

// 4,5

// 0 -> 1 -> 2 -> 