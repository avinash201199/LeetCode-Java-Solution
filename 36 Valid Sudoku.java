class Solution {
    public boolean isValidSudoku(char[][] board) {
        // validate globally
        int[][] rows = new int[10][10];
        int[][] cols = new int[10][10];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char cell = board[r][c];
                if (!Character.isDigit(cell)) {
                    continue;
                }
                int d = toInt(cell);
                rows[r][d]++;
                cols[c][d]++;
                if (rows[r][d] > 1 || cols[c][d] > 1) {
                    return false;
                }
            }
        }
        
        // validate locally
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                if (!validSubBox(board, r, c)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int toInt(char c) {
        return c - '0';
    }
    
    private boolean validSubBox(char[][] board, int row, int col) {
        int[] subBox = new int[10];
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                char cell = board[r][c];
                if (Character.isDigit(cell)) {
                    int d = toInt(cell);
                    subBox[d]++;
                    if (subBox[d] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
