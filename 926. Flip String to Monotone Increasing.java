class Solution {
    public int minFlipsMonoIncr(String s) {
          int dp[][]=new int[2][s.length()+1];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
               dp[0][i+1]=dp[0][i];
               dp[1][i+1]=1+Math.min(dp[0][i],dp[1][i]);
            }
            else{
              dp[0][i+1] = dp[0][i] + 1;
              dp[1][i+1] = Math.min(dp[0][i], dp[1][i]);
            }
        }
        
        return Math.min(dp[0][s.length()],dp[1][s.length()]);
    }
}
