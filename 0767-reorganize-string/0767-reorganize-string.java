class Solution {
    public String reorganizeString(String s) {
        int[] charCount = new int[26];

        for(int i =0 ; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> {
            return Integer.compare(b[1], a[1]);
        });

        for(int i = 0; i < 26; i++) {
            if(charCount[i] > 0) {
                minHeap.offer(new int[] { i + 'a', charCount[i]});
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!minHeap.isEmpty()) {
            int[] first = minHeap.poll();

            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != first[0]) {
                sb.append((char)first[0]);

                if(--first[1] > 0) {
                    minHeap.offer(first);
                }
            }

            else {
                if(minHeap.isEmpty()) {
                    return "";
                }

                int[] second = minHeap.poll();
                sb.append((char) second[0]);

                if(--second[1] > 0) {
                    minHeap.offer(second);
                }
                minHeap.offer(first);
            }
        }
        return sb.toString();

    }
}