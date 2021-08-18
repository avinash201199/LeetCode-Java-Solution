class Solution {
    public int numDecodings(String s) {
        
        if (s == null || s.length () == 0 || s.charAt (0) == '0') {
            return 0;
        }
        
        int length = s.length ();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        if (s.charAt (length - 1) != '0') {
            dp[length - 1] = 1;
        }
        
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt (i) != '0') {
                dp[i] = dp[i + 1];
            }
            if (s.charAt (i) == '1') {
                dp[i] += dp[i + 2];
            }
            if (s.charAt (i) == '2' && s.charAt (i + 1) >= '0' && s.charAt (i + 1) <= '6') {
                dp[i] += dp[i + 2];
            }
        }
        
        return dp[0];
    }
}
