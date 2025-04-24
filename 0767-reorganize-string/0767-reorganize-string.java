class Solution {
    public String reorganizeString(String s) {
        
        int[] charCounts = new int[26];

        for(Character c: s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> {
            return Integer.compare(b[1], a[1]);
        });

        for(int i = 0; i < 26; i++) {
            if(charCounts[i] > 0) {
                maxHeap.offer(new int[] {i + 'a', charCounts[i]});
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();

            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != first[0]) {
                sb.append((char) first[0]);

                if(--first[1] > 0) {
                    maxHeap.offer(first);
                }
            }

            else {
                if(maxHeap.isEmpty()) {
                    return "";
                }

                int[] second = maxHeap.poll();

                sb.append((char) second[0]);

                if(--second[1] > 0) {
                    maxHeap.offer(second);
                }
                maxHeap.offer(first);
            }
        }

        return sb.toString();
    }
}