class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap();
        Map<Character, Integer> charIndegree = new HashMap();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList());
                charIndegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];

            int minLen = Math.min(w1.length(), w2.length());

            boolean found = false;

            for(int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1 != c2) {
                    if(!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        charIndegree.put(c2, charIndegree.get(c2) + 1);
                    }
                    found = true;
                    break;
                }
            }

            if(!found && w1.length() > w2.length()) {
                return "";
            }
        }

        Queue<Character> queue = new LinkedList();

        for(char c: charIndegree.keySet()) {
            if(charIndegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();

        while(!queue.isEmpty()) {
            char polledChar = queue.poll();
            
            res.append(polledChar);

            for(char neighbor : graph.get(polledChar)) {
                charIndegree.put(neighbor, charIndegree.get(neighbor) - 1);
                if(charIndegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return res.length() == graph.size() ? res.toString() : "";

        
    }
}