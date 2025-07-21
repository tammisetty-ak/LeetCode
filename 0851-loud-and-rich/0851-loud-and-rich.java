class Solution {
    int[] answer;
    int[] quiet;
    ArrayList<ArrayList<Integer>> graph;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        graph = new ArrayList();
        int n = quiet.length;

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList());
        }

        for(int[] rich : richer) {
            graph.get(rich[1]).add(rich[0]);
        }

        answer = new int[n];
        this.quiet = quiet;

        Arrays.fill(answer, -1);

        for(int node = 0; node < n; node++) {
            dfs(node);
        }

        return answer;

    }

    private int dfs(int node) {
        if(answer[node] == -1) {
            answer[node] = node;
            for(int child: graph.get(node)) {
                int cand = dfs(child);
                if(quiet[cand] < quiet[answer[node]]) {
                    answer[node] = cand;
                }
            }
        }

        return answer[node];
    }

}

// 0 - 0,2 1,2 2 3 4 5 6

