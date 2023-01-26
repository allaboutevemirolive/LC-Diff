class B63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // number of rows
        int n = obstacleGrid[0].length; // number of columns
        int[] dp = new int[n]; 
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1; // if starting point is obstacle, return 0. Otherwise, return 1.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) { // if current cell is obstacle
                    dp[j] = 0; // mark the number of path to it as 0
                } else if (j > 0) { // if current cell is not obstacle and not the first column
                    dp[j] += dp[j - 1]; // add the number of path to the left cell
                }
            }
        }
        return dp[n - 1]; // return the number of path to the last column of the last row
    }
}
