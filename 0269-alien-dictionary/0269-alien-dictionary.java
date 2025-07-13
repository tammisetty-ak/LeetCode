class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Initialize graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Build graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            boolean found = false;

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    found = true;
                    break;
                }
            }

            // Invalid case like ["abc", "ab"]
            if (!found && w1.length() > w2.length()) {
                return "";
            }
        }

        // BFS - Kahn’s Algorithm
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            res.append(cur);
            for (char neighbor : graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If not all letters are used, there is a cycle
        return res.length() == graph.size() ? res.toString() : "";
    }
}
