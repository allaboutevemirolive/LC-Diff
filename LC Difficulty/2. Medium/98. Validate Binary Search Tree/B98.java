class B98 {
    // Main method to check if a binary tree is a valid BST
    public boolean isValidBST(T98 root) {
        // Call the helper method isSubtree to check if the binary tree is a valid BST
        return isSubtree(root, null, null);
    }

    // Helper method to check if a binary tree is a valid BST
    public boolean isSubtree(T98 root, Integer min, Integer max) {
        // If the root is null, it is a valid BST
        if (root == null) {
            return true;
        }
        // If the value of the root is less than or equal to the minimum value or greater than or equal to the maximum value, it is not a valid BST
        if (min != null && root.val <= min || max != null && root.val >= max) {
            return false;
        }
        // Check the left subtree with the updated minimum and current root value as maximum
        // Check the right subtree with the updated maximum and current root value as minimum
        // Both the left and right subtrees must also be binary search trees for the overall tree to be a valid BST
        return isSubtree(root.left, min, root.val) && isSubtree(root.right, root.val, max);
    }
}
