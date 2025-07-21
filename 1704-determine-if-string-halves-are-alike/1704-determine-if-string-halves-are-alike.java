class Solution {

    Set<Character> set;
    public boolean halvesAreAlike(String s) {
        set = new HashSet();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        return countVowels(s.substring(0, s.length() / 2)) == countVowels(s.substring(s.length() / 2));
    }

    private int countVowels(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                count++;
            }
        }

        return count;
    }
}