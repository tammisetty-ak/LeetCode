class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int speed = 1;
        while(true) {
            int hourSpent = 0;
            for(int pile: piles) {
                hourSpent += Math.ceil((double)pile / speed);
                if(hourSpent > h) {
                    break;
                }
            }

            if(hourSpent <= h) {
                return speed;
            }
            else {
                speed++;
            }
        }
    }
}