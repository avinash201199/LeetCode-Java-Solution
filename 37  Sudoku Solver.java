class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
               if(board[i][j] == '.'){
                   for(char c = '1'; c<='9'; c++){
                       if(isValid(board,i,j,c)){ // Validating if the selected char at the position(i,j) is valid or not
                           board[i][j] = c;
                           if(solve(board)){ 
                               return true; 
                           } else {
                               board[i][j] = '.'; //Backtrack and set the old value
                           }
                   }
               }
                   return false; // here this returning of false means, we reached till the end and found that no element can be kept,so                                  // we need to backtrack now :)
            }
        }
    }
        return true;
}
    
    public boolean isValid(char[][] board, int row, int col, char c){
        for(int i=0; i<9; i++){
            if(board[row][i] == c) //checking for single row [horizontal] and all 9 columns
                return false;
            if(board[i][col] == c) // checking for single column [vertical] and all 9 rows
                return false;
            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] == c) //checking for the values in submatrix [3 X 3]
                return false;
        }
        return true;
}
}
