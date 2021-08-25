class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int)Math.pow(c, 0.5);
        while(i <= j){
            int val = (i*i) + (j*j);
            if(val == c)
                return true;
            if(val > c)
                j--;
            else
                i++;
        }
        return false;
    }
}
