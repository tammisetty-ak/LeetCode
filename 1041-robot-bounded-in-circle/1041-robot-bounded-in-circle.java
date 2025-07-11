class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x = 0, y = 0;

        int idx = 0;
        for(char i : instructions.toCharArray()){
            if(i == 'L') {
                idx = (idx + 3) % 4;
            }
            else if (i == 'R') {
                idx = (idx + 1) % 4;
            }

            else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }

        return (x == 0 && y == 0) || (idx != 0);
    }
}

/*
GL

(0, 0)

G -> up -> (0, 1) -> (0, 1)
L -> left -> (-1, 0) + (0, 1) -> (-1, 1)
*/