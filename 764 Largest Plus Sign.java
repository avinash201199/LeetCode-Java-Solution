class Solution {
	public int orderOfLargestPlusSign(int n, int[][] mines) {
	//lets switch 0 and 1 
		int[][] arr= new int[n][n];
		for(int i=0;i<mines.length;i++){
			arr[mines[i][0]][mines[i][1]]=1;
		}
		for(int i=n;i>=0;i--){
			if(dp(arr,0,0,i)){
				return i+1;
			}
		}
		return 0;
	}
	public boolean dp(int[][]arr,int x , int y, int k){
		if(x-k<0){
			return dp(arr,k,y,k);
		}if(y-k<0){
			return dp(arr,x,k,k);
		}if(x+k>=arr.length){
			return false;
		}if(y+k>=arr.length){
			return dp(arr,x+1,k,k);
		}
			for(int i=x-k;i<=x+k;i++){

				if(arr[i][y]==1){
					return dp(arr,x,y+1,k);
				}
			}
			for(int i=y-k;i<=y+k;i++){

				if(arr[x][i]==1){

					return dp(arr,x,y+1,k);
				}
			}

		return true;
	}
}
