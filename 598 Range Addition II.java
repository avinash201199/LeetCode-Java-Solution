class Solution {
	public int maxCount(int m, int n, int[][] ops) {
		if(ops.length == 0){
			return m*n;
		}

		int min_row = Integer.MAX_VALUE;
		int min_col = Integer.MAX_VALUE;
		for(int i=0; i<ops.length; i++){
			min_col = Math.min(ops[i][0], min_col);
			min_row = Math.min(ops[i][1], min_row);
		}

		return min_row * min_col;
	}
}
