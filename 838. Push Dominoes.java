class Solution {
    public String pushDominoes(String dominoes) {
        char[] state  = dominoes.toCharArray();
	   int len = state.length;
	   int reset = Integer.MIN_VALUE + len;
	   int posR = reset ; 
    
		for(int i =0 ; i< len; i++){
			if(state[i] == 'R'){
				posR =i;
			} else if(state[i] == 'L'){
				int j = i-1;
				while(j >-1 && state[j] != 'L' &&  (i-j <= (i-posR)/2)){
					state[j--] = 'L';
				}
            
				if(posR != reset && (i-posR)%2 == 0){
					state[++j] = '.';
				}
				posR = reset;
            
			} else if(posR != reset){
				 state[+i] = 'R';
			}
		}
    
    return new String(state);
    }
}
