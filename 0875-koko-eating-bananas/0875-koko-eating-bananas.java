class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;

        for(int pile: piles) {
            right = Math.max(right, pile);
        }

        while(left < right) {
            int middle = left + (right - left) / 2;

            int hours = 0;

            for(int pile : piles) {
                hours += Math.ceil((double) pile / middle);
            }

            if(hours <= h) {
                right = middle;
            }
            else {
                left = middle + 1;
            }
        }

        return right;
    }
}