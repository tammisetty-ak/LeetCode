class Solution {
    public int[][] generateMatrix(int n) {
        int rows = n, cols = n;
        int left = 0, right = cols - 1, up = 0, down = rows - 1;
        int[][] matrix = new int[rows][cols];
        int num = 1;
        while(num <= n * n) {
            for(int col = left; col <= right; col++) {
                matrix[up][col] = num++;
            }

            for(int row = up + 1; row <= down; row++) {
                matrix[row][right] = num++;
            }

            if(up != down) {
                for(int col = right - 1; col >= left; col--) {
                    matrix[down][col] = num++;
                }
            }

            if(left != right) {
                for(int row = down - 1; row > up; row--) {
                    matrix[row][left] = num++;
                }
            }
            left++;
            right--;
            up++;
            down--;
        }

        return matrix;
    }
}

/*

n = 3

    1 2 3
    8 9 4
    7 6 5

1 2 3, 8 9 4, 7 6 5

n = 4

    1  2  3  4
    12 13 14 5
    11 16 15 6
    10 9  8  7

n = 5

    1  2  3  4  5
    16 17 18 19 6
    15 24 25 20 7
    14 23 22 21 8
    13 12 11 10 9   

    
*/