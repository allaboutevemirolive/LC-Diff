class B96 {
    public int numTrees(int n) {
        // create an array to store the number of unique BST's with i nodes
        int[] dp = new int[n + 1];
        
        // base case: there is 1 unique BST with 0 or 1 node
        dp[0] = 1;
        dp[1] = 1;
        
        // loop through each number of nodes i
        for (int i = 2; i <= n; i++) {
            // loop through each possible root j
            for (int j = 1; j <= i; j++) {
                // the number of unique BST's with i nodes is the sum of
                // the product of the number of BST's with j-1 nodes as the left subtree
                // and the number of BST's with i-j nodes as the right subtree
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        // return the number of BST's with n nodes
        return dp[n];
    }
}
