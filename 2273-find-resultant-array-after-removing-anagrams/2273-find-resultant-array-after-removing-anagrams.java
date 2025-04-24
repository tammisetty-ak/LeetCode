class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prevSorted = sortString(words[0]);
        result.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String currentSorted = sortString(words[i]);
            if (!currentSorted.equals(prevSorted)) {
                result.add(words[i]);
                prevSorted = currentSorted;
            }
        }
        return result;
    }

    private String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}