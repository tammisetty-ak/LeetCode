class Solution {
    public int maxNumberOfBalloons(String text) {
    //    Map<Character, Integer> map = new HashMap();
    //    for(char c : text.toCharArray()) {
    //         if("balon".contains(c)) {
    //             map.put(c, map.getOrDefault(c, 0) + 1);
    //         }
    //    } 

    //    if(map.size() < 5) {
    //     return 0;
    //    }
    //    else {
    //         while((Map.entrySet<Character, Integer> entry : map.entrySet()) {
    //             if("ban".contains(entry.getKey())) {
    //                 map.put(entry.getKey(), entry.getValue() - 1);
    //             }
    //             else if("lo".contains(entry.getKey())) {
    //                 map.put(entry.getKey(), entry.getValue() - 2);                   
    //             }
    //         }
    //    }
        int count = 0;
        int[] chars = new int[26];

        for(char c : text.toCharArray()) {
            chars[c - 'a']++;
        }

        while(chars[0] >= 1 && chars[1] >= 1 && chars[11] >= 2 && chars[13] >= 1 && chars[14] >= 2 ) {
            chars[0] -= 1;
            chars[1] -= 1;
            chars[11] -= 2;
            chars[13] -= 1;
            chars[14] -= 2;
            count++;
        }

        return count;
    }
}