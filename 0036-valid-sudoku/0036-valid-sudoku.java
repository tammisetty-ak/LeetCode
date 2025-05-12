class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[] boxSet = new HashSet[9];

        int N = 9;

        for(int i = 0; i < N; i++) {
            rowSet[i] = new HashSet();
            colSet[i] = new HashSet();
            boxSet[i] = new HashSet();
        }


        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0; j < 9; j++) {
                char val = board[i][j];

                if(val == '.') {
                    continue;
                }
                if(rowSet[i].contains(val)) {
                    return false;
                }
                rowSet[i].add(val);
                if(colSet[j].contains(val)) {
                    return false;
                }
                colSet[j].add(val);

                int index = (i / 3) * 3 + (j / 3);

                if(boxSet[index].contains(val)) {
                    return false;
                }

                boxSet[index].add(val);
            }
        }

        return true;

    }
}