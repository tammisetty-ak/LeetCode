class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            
            freq[i]--;  // Try removing one occurrence of this character
            
            if (allSame(freq)) {
                return true;
            }
            
            freq[i]++;  // Restore the count
        }
        
        return false;
    }
    
    private boolean allSame(int[] freq) {
        int target = 0;
        for (int f : freq) {
            if (f == 0) continue;
            if (target == 0) {
                target = f;
            } else if (f != target) {
                return false;
            }
        }
        return true;
    }
}
