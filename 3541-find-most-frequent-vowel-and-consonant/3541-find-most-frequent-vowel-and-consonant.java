class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vowF = new HashMap();
        HashMap<Character, Integer> conF = new HashMap();

        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                vowF.put(c, vowF.getOrDefault(c, 0) + 1);
            }
            else {
                conF.put(c, conF.getOrDefault(c, 0) + 1);
            }
        }

        int maxV = 0, maxC = 0;

        for(int v : vowF.values()) {
            maxV = Math.max(v, maxV);
        }
        for(int co : conF.values()) {
            maxC = Math.max(co, maxC);
        }

        return maxV + maxC;

    }
}