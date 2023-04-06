import java.util.Arrays;

class B62 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        // fill the array with 1 as the initial condition
        Arrays.fill(dp, 1);  
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // use the formula dp[j] = dp[j] + dp[j-1]
                dp[j] += dp[j - 1];  
            }
        }
        // return the last element of the dp array, which is the number of unique paths
        return dp[n - 1];  
    }
}
