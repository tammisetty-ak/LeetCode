class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for(char move: moves.toCharArray()) {
            if(move == 'U' || move == 'D') {
                y += move == 'U' ? 1 : -1;
            }
            else {
                x += move == 'R' ? 1 : -1;
            }
        }

        return x == 0 && y == 0;
    }
}