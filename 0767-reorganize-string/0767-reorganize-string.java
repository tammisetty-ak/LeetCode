class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> {
            return Integer.compare(b[1], a[1]);
        });
        
        int[] charCounts = new int[26];

        for(char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(charCounts[i] > 0)
                maxHeap.offer(new int[] {i + 'a', charCounts[i]});
        }
        
        StringBuilder res = new StringBuilder();
        
        while(!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();

            if(res.length() == 0 || res.charAt(res.length() - 1) != first[0]) {
                res.append((char) first[0]);
                if(--first[1] > 0) {
                    maxHeap.offer(first);
                }
            }
            else {
                if(maxHeap.isEmpty()) {
                    return "";
                }

                int[] second = maxHeap.poll();

                res.append((char)second[0]);
                if(--second[1] > 0) {
                    maxHeap.offer(second);
                }
                maxHeap.offer(first);
            }
        }

        return res.toString();
    }
}

// aab

// a - 2
// b - 1

// a

// b - 1 a - 1 

// ab

// aba