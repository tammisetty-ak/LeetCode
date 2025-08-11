class Solution {
    List<List<String>> res;
    int size;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList();
        size = n;
        char[][] emptyBoard = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(emptyBoard[i], '.');
        }

        backtrack(0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), emptyBoard);
        return res;
    }

    private void addRes(char[][] emptyBoard) {
        List<String> board = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            board.add(new String(emptyBoard[i]));
        }
        res.add(board);
    }

    void backtrack(int row, HashSet<Integer> cols, HashSet<Integer> diagonals, HashSet<Integer> antiDiagonals, char[][] emptyBoard) {
        if(row == size) {
            addRes(emptyBoard);
            return;
        }

        for(int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            if(diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal) || cols.contains(col)) {
                continue;
            }

            cols.add(col);
            antiDiagonals.add(currAntiDiagonal);
            diagonals.add(currDiagonal);
            emptyBoard[row][col] = 'Q';
        
            backtrack(row + 1, cols, diagonals, antiDiagonals, emptyBoard);

            cols.remove(col);
            antiDiagonals.remove(currAntiDiagonal);
            diagonals.remove(currDiagonal);
            emptyBoard[row][col] = '.';
        }
    }
}