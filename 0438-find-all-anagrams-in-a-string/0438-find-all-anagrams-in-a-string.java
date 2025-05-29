class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length(), sLen = s.length();

        if (sLen < pLen) return new ArrayList<>();

        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < sLen; i++) {
            // Add current character to window
            char rightChar = s.charAt(i);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            // Shrink window if it's larger than p
            if (i >= pLen) {
                char leftChar = s.charAt(i - pLen);
                if (window.get(leftChar) == 1) {
                    window.remove(leftChar);
                } else {
                    window.put(leftChar, window.get(leftChar) - 1);
                }
            }

            // Compare maps
            if (window.equals(pMap)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }
}
