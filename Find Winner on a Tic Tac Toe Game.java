class Solution {
	
    public static String tictactoe(int[][] moves) {
    	
    	char[][] grid = playAll(moves);
    	
    	for(int i=0; i<grid.length; i++) {
    		if(grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2] && grid[i][0] != '.') {
    			if(grid[i][0]=='X')
    				return "A";
    			else return "B";
    		}
    		if(grid[0][i] == grid[1][i] && grid[0][i] == grid[2][i] && grid[0][i] != '.') {
    			if(grid[0][i]=='X')
    				return "A";
    			else return "B";
    		}
    	}
    	
    	if(grid[1][1]!='.') {
    		if(grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2] && grid[0][0] != '.') {
    			if(grid[0][0]=='X')
    				return "A";
    			else return "B";
    		}
        	
        	if(grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0] && grid[0][2] != '.') {
    			if(grid[0][2]=='X')
    				return "A";
    			else return "B";
    		}
    	}
    	
    	return moves.length == 9 ? "Draw" : "Pending";
    		
    	
        
    }
    
    public static char[][] playAll(int[][] moves){
    	char[][] grid = {{'.', '.', '.'},{'.', '.', '.'},{'.', '.', '.'}};
    	boolean turnA = true;
    	for(int[] move : moves) {
    		if(turnA) 
    			grid[move[0]][move[1]] = 'X';
    		else
    			grid[move[0]][move[1]] = '0';
    		turnA = !turnA;    
    	}
    	return grid;
    		
    }
    
}
