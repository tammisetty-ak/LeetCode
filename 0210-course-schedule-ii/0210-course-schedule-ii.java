class Solution {

    int[] res;
    Map<Integer, List<Integer>> graph;
    int index;
    int[] indegree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new HashMap<Integer, List<Integer>>();
        index = 0;
        indegree = new int[numCourses];
        res = new int[numCourses];

        for(int[] prerequisite : prerequisites) {
            int vertice = prerequisite[1];
            if(!graph.containsKey(prerequisite[1])) {
                graph.put(vertice, new ArrayList<Integer>());
            }
            List<Integer> neighbors = graph.get(vertice);
            neighbors.add(prerequisite[0]);
            graph.put(vertice, neighbors);
graph.putIfAbsent(prerequisite[0], new ArrayList<>());
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> zeroDegree = new LinkedList();
        for(int  i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                zeroDegree.add(i);
                if(!graph.containsKey(i)) {
                    graph.put(i, new ArrayList());
                }
            }
        }

        while(!zeroDegree.isEmpty()) {
            int course = zeroDegree.poll();
            res[index++] = course;
            for(Integer neighbor : graph.get(course)) {
                if(--indegree[neighbor] == 0) {
                    zeroDegree.offer(neighbor);
                }
            }
        }

        for(int in: indegree) {
            if(in != 0) {
                return new int[0];
            }
        }

        return res;

        // for(int i = 0; i < numCourses; i++) {
        //     if(states[i] == 0) {
        //         if(!dfs(i)) {
        //             return new int[0];
        //         }
        //     }
        // }

        // return res;


    }

    // private boolean dfs(int vertice) {
    //     if(states[vertice] == 2) {
    //         return true;
    //     }
    //     if(states[vertice] == 1) {
    //         return false;
    //     }

    //     states[vertice] = 1;
    //     for(Integer neighbor : graph.getOrDefault(vertice, new ArrayList<Integer>())) {
    //         if(!dfs(neighbor)) {
    //             return false;
    //         }
    //     }
    //     states[vertice] = 2;
    //     res[index--] = vertice;
    //     return true;
    // }
}

// [1,0] [2, 0] [3, 1] [3, 2]

// 0 -> 1, 2
// 1 -> 3
// 2 -> 3
