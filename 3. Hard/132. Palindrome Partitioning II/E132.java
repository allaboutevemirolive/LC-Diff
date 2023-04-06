import java.util.Arrays;

class E132 {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for (int i = 0; i < s.length(); i++) {
            expandFromMiddle(s, i, i, dp);
            expandFromMiddle(s, i, i + 1, dp);
        }
        
        return dp[s.length() - 1];
    }
    
    private void expandFromMiddle(String s, int lo, int hi, int[] dp) {
        
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            if (lo == 0) {
                dp[hi] = 0;
            } else {
                dp[hi] = Math.min(dp[hi], dp[lo - 1] + 1);
            }
            
            lo--;
            hi++;
        }
        
    }
    
}