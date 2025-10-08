public class Solution {
    public int[] SuccessfulPairs(int[] spells, int[] potions, long success) {
        Array.Sort(potions);
        int[] res = new int[spells.Length];
        int i = 0;

        foreach(int spell in spells) {

            int left = 0, right = potions.Length - 1, index = potions.Length;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) potions[mid] * spell;

                if(product >= success) {
                    index = mid;
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            
            res[i++] = potions.Length - index;
        }

        return res;
    }
}