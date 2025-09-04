class Solution {
    public int findClosest(int x, int y, int z) {
        int yd = Math.abs(z - y);
        int xd = Math.abs(z - x);
        if(yd == xd) {
            return 0;
        }
        else if(yd > xd) {
            return 1;
        }
        else {
            return 2;
        }
    }
}