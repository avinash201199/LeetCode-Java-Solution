class Solution {
    public int numDistinct(String text1, String text2) {
        
     int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        int ans = numD(n, m,text1, text2, dp);

        return ans;   
        
    }
    
    public int numD(int n,int m,String str1,String str2,int[][] dp){
        if(m == 0)
            return dp[n][m] = 1;
        if(m > n) 
            return dp[n][m] = 0;
        if(dp[n][m] != -1)
            return dp[n][m];
        
        
        int a = numD(n-1,m-1,str1,str2,dp);
        int b = numD(n-1,m,str1,str2,dp);
        
        
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = a + b;
            
        }else{
            dp[n][m] = b;
        }
        return dp[n][m];
    }
    
}
