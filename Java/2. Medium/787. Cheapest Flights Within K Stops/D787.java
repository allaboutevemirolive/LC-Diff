import java.util.Arrays;

//Dynamic Programming
class D787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Initialize 2D array "dp" with dimensions (k+2)xn to store minimum cost
        int[][] dp = new int[k + 2][n];
        // fill the array with maximum value
        for (int i = 0; i <= k + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // Set the minimum cost to reach source city as 0
        for (int i = 0; i <= k + 1; i++) {
            dp[i][src] = 0;
        }
        // loop through flights
        for (int i = 1; i <= k + 1; i++) {
            for (int[] f : flights) {
                // check if it is possible to reach the city from previous city
                if (dp[i - 1][f[0]] != Integer.MAX_VALUE) {
                    // Update the minimum cost to reach the current city
                    dp[i][f[1]] = Math.min(dp[i][f[1]], dp[i - 1][f[0]] + f[2]);
                }
            }
        }
        // check if it is possible to reach the destination city
        // if yes return the minimum cost, else return -1
        return dp[k + 1][dst] == Integer.MAX_VALUE ? -1 : dp[k + 1][dst];
    }
}