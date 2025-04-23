class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();

        for(String vote: votes) {
            for(int i = 0; i < vote.length(); i++) {
                char curr = vote.charAt(i);
                map.putIfAbsent(curr, new int[n]);
                map.get(curr)[i]++;
            }
        }

        List<Character> teams = new ArrayList(map.keySet());
        teams.sort((a, b) -> {
            for(int i =0; i < n; i++) {
                if(map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });

        StringBuilder res = new StringBuilder();
        for(Character t: teams) {
            res.append(t);
        }

        return res.toString();
    }
}