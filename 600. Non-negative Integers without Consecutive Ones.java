class Solution {
    public  int findIntegers(int num) {
        if(num <= 2) return num+1;
        int ans = 1;
        if(num%2 == 1){
            ans = 2;
        }
        int zero = 1 , one = 1;
        for(int i = 1 ; i < 32 ; i++){
            int pzero = zero;
            zero = pzero + one;
            one = pzero;
            if((num&(1<< i)) > 0){
                if((num&(1<<i-1)) > 0){
                    ans = zero + pzero;
                }else{
                    ans = zero + ans;
                }
            }
        }
        return ans;
    }
}
