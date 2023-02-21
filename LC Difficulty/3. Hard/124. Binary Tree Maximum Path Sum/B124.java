class B124 {
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(T124 root) {
        maxPathSumHelper(root);
        return maxPathSum;
    }

    private int maxPathSumHelper(T124 node) {
        if (node == null) {
            return 0;
        }
        
        // Recursively find the maximum path sum in the left and right subtrees
        int left = Math.max(maxPathSumHelper(node.left), 0);
        int right = Math.max(maxPathSumHelper(node.right), 0);

        // Compute the maximum path sum that includes the current node
        int currentMaxPathSum = node.val + left + right;

        // Update the maximum path sum found so far
        maxPathSum = Math.max(maxPathSum, currentMaxPathSum);

        // Return the maximum path sum that ends at the current node
        return node.val + Math.max(left, right);
    }
}