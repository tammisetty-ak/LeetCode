class Solution {

    int[] res;
    Map<Integer, List<Integer>> graph;
    int[] states;
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        states = new int[numCourses];
        graph = new HashMap<Integer, List<Integer>>();
        index = numCourses - 1;
        res = new int[numCourses];

        for(int[] prerequisite : prerequisites) {
            int vertice = prerequisite[1];
            if(!graph.containsKey(prerequisite[1])) {
                graph.put(vertice, new ArrayList<Integer>());
            }
            List<Integer> neighbors = graph.get(vertice);
            neighbors.add(prerequisite[0]);
            graph.put(vertice, neighbors);
        }

        for(int i = 0; i < numCourses; i++) {
            if(states[i] == 0) {
                if(!dfs(i)) {
                    return new int[0];
                }
            }
        }

        return res;
    }

    private boolean dfs(int vertice) {
        if(states[vertice] == 2) {
            return true;
        }
        if(states[vertice] == 1) {
            return false;
        }

        states[vertice] = 1;
        for(Integer neighbor : graph.getOrDefault(vertice, new ArrayList<Integer>())) {
            if(!dfs(neighbor)) {
                return false;
            }
        }
        states[vertice] = 2;
        res[index--] = vertice;
        return true;
    }
}

// [1,0] [2, 0] [3, 1] [3, 2]

// 0 -> 1, 2
// 1 -> 3
// 2 -> 3
