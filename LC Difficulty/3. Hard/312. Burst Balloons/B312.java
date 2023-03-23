class B312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Initialize a 2D array for dynamic programming with size n+2 x n+2
        int[][] dp = new int[n + 2][n + 2];
        // Initialize a variable to keep track of the distance from the end of the array
        int distFromEnd = 2;
        
        // Loop through the array backwards, starting from the second to last element
        for (int end = n - 1; end >= 0; end--) {
            // Loop through all possible subarrays starting from the beginning of the array
            for (int start = 0; start <= end; start++) {
                // Calculate the end index of the subarray
                int subarrayEnd = start + distFromEnd;
                
                // Initialize a variable to keep track of the maximum number of coins that can be earned
                int maxCoins = 0;
                
                // Calculate the left and right values for the current subarray
                int leftValue = start == 0 ? 1 : nums[start - 1];
                int rightValue = subarrayEnd == n + 1 ? 1 : nums[subarrayEnd - 1];
                
                // Loop through all possible positions to burst a balloon within the subarray
                for (int k = start + 1; k <= subarrayEnd - 1; k++) {
                    // Calculate the number of coins that can be earned by bursting the balloon at position k
                    int coinsEarned = dp[start][k] + dp[k][subarrayEnd] + (leftValue * nums[k - 1] * rightValue);
                    // Update maxCoins if coinsEarned is greater than the current maximum
                    maxCoins = Math.max(maxCoins, coinsEarned);
                }
                
                // Set the maximum number of coins that can be earned for this subarray in the dp array
                dp[start][subarrayEnd] = maxCoins;
            }
            // Increment the distance from the end of the array for the next iteration
            distFromEnd++;
        }
        
        // Return the maximum number of coins that can be earned for the entire array
        return dp[0][n + 1];
    }
}
