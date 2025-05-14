class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0, high = rows - 1;

        while(low <= high) {
            int midRow = low + (high - low) / 2;

            if(matrix[midRow][0] > target) {
                high = midRow - 1;
            }
            else if(matrix[midRow][cols-1] < target) {
                low = midRow + 1;
            }
            else {
                int left = 0, right = matrix[midRow].length - 1;
                while(left <= right) {
                    int midCol = left + (right - left) / 2;

                    if(matrix[midRow][midCol] < target) {
                        left = midCol + 1;
                    }
                    else if(matrix[midRow][midCol] > target) {
                        right = midCol - 1;
                    }
                    else {
                        return true;
                    }
                }

                return false;
            }
        }

        return false;


    }
}
