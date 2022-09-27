class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        Set<Character> rowSet = null;
        Set<Character> colSet = null;
        
        // check rows
        for (int i = 0; i < rows; i++) {
            rowSet = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (rowSet.contains(c)) return false;
                rowSet.add(c);
            }
        }
        
        // check columns
        for (int i = 0; i < cols; i++) {
            colSet = new HashSet<>();
            for (int j = 0; j < rows; j++) {
                char c = board[j][i];
                if (c == '.') continue;
                if (colSet.contains(c)) return false;
                colSet.add(c);
            }
        }
        
        // check blocks
        for (int i = 0; i < rows; i = i + 3) {
            for (int j = 0; j < cols; j = j + 3) {
                if (!checkBlock(i, j, board)) return false;
            }
        }
        
        return true;
    }
    
    private boolean checkBlock(int indexI, int indexJ, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        int rows = indexI + 3;
        int cols = indexJ + 3;
        for (int i = indexI; i < rows; i++) {
            for (int j = indexJ; j < cols; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (blockSet.contains(c)) return false;
                blockSet.add(c);
            }
        }
        
        return true;
    }
}
