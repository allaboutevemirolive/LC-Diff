class B99 {
    // prev node to track the previous node during inorder traversal
    T99 prev = null;
    // nodes to store the first and second nodes that have incorrect values
    T99 firstMistakenNode = null;
    T99 secondMistakenNode = null;

    // function to perform inorder traversal of the tree
    void inorderTraversal(T99 root) {
        if (root == null)
            return;

        // traverse the left subtree
        inorderTraversal(root.left);

        // compare the current node's value with the previous node's value
        // If the current node is smaller than the previous node, it means it's incorrect
        if (prev != null && root.val < prev.val) {
            // if this is the first mistake found, store the previous node
            if (firstMistakenNode == null) {
                firstMistakenNode = prev;
            }
            // store the current node as the second mistake node
            secondMistakenNode = root;
        }

        // store the current node as the previous node
        prev = root;
        // traverse the right subtree
        inorderTraversal(root.right);
    }

    public void recoverTree(T99 root) {
        if (root == null)
            return;

        // perform inorder traversal of the tree
        inorderTraversal(root);

        // swap the values of the two mistaken nodes
        int temp = firstMistakenNode.val;
        firstMistakenNode.val = secondMistakenNode.val;
        secondMistakenNode.val = temp;
    }
}
