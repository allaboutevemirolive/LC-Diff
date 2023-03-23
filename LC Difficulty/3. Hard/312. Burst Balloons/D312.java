import java.util.Arrays;

/*Print the output then compare it with 

[[0, 3, 30, 159, 167, 0],
[0, 0, 15, 135, 159, 0],
[0, 0, 0, 40, 48, 0],
[0, 0, 0, 0, 40, 0],
[0, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0]]



1 [3, 1, 5, 8] 1
*/

// The class below is the solution to the Burst Balloons problem
class D312 {
    public int maxCoins(int[] nums) {
        // Get the length of the input array and create a dp array with 2 extra slots for the left and right boundaries
        int n = nums.length;
        // The extra two slots are added to the left and right of the array to handle out-of-bounds balloons.
        int[][] dp = new int[n + 2][n + 2];

        // Iterate from the second last index to the first index
        for (int left = n - 1; left >= 0; left--) {
            // Iterate from the current left index to the last index
            for (int right = left; right < n; right++) {
                // If the left index is greater than the right index, skip the current iteration
                if (left > right) continue;
                // Get the value of the previous balloon and next balloon, treating out of bounds indices as having a value of 1
                int previous = left > 0 ? nums[left - 1] : 1;
                int next = right < n - 1 ? nums[right + 1] : 1;
                int max = -1;
                // For each pair of 'left' and 'right' indices, the code calculates the maximum coins that can be obtained 
                // by bursting all balloons between them
                // To do this, it iterates through all the balloons from left to right using a variable called mid
                for (int mid = left; mid <= right; mid++) {
                    // Calculate the coins that can be obtained by bursting the current balloon, using the value of the previous balloon, next balloon, and current balloon
                    // properly apply dynamic programming and avoid recomputing the same subproblems multiple times.
                    System.out.println("left: " + left + ", right: " + right + ", mid: " + mid);
                    System.out.println("previous: " + previous + ", next: " + next + ", nums[mid]: " + nums[mid]);
                    System.out.println("dp[left][mid]: " + dp[left][mid] + ", dp[mid + 1][right + 1]: " + dp[mid + 1][right + 1]);
                    int coins = (previous * next * nums[mid]) + dp[left][mid] + dp[mid + 1][right + 1];
                    System.out.println("coins: " + coins + "");
                    // Update the maximum coins that can be obtained
                    max = Math.max(max, coins);
                    System.out.println("max: " + max );
                    System.out.println("--------------------");
                }
                // Set the value in the dp array for the current left and right indices to be the maximum coins that can be obtained
                System.out.println("Setting dp[" + left + "][" + (right + 1) + "] to " + max + "");
                System.out.println("Printing dp array for left: " + left + ", right: " + right);
                System.out.println("dp[" + left + "][" + (right + 1) + "]: " + dp[left][right + 1] + "");
                dp[left][right + 1] = max;
                System.out.println("Printing dp array for left: " + left + ", right: " + right);
                System.out.println(Arrays.deepToString(dp).replace("], ", "],\n"));
                System.out.println("====================================");
                System.out.println();
            }
        }
        // Return the maximum coins that can be obtained from bursting all the balloons
        return dp[0][n];
    }
}
