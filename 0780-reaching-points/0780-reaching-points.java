class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx > sx && ty > sy) {
            if(tx > ty) {
                tx -= ty;
            }
            else {
                ty -= tx;
            }
        }

        if(sx == tx && sy <= ty && (ty - sy) % sx == 0) {
            return true;
        }

        return (sy == ty && sy <= tx && (tx - sx) % sy == 0);
    }
}