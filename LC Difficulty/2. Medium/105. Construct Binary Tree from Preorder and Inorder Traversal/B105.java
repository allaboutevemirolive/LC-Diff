class B105 {
    private int preIndex; // keeps track of the index of the next node in preorder array
    private int inIndex; // keeps track of the index of the next node in inorder array
    
    public T105 buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, Integer.MAX_VALUE);
    }
    
    private T105 buildTreeHelper(int[] preorder, int[] inorder, int stopValue) {
        // if all nodes have been processed or the current node is a leaf
        if (preIndex >= preorder.length || inorder[inIndex] == stopValue) {
            inIndex++; // move to next node in inorder array
            return null; // return null to indicate the end of a branch
        }
        
        int rootValue = preorder[preIndex++]; // get the value of the current node
        T105 root = new T105(rootValue); // create the current node
        
        // recursively build left and right subtrees using the inorder array to determine the node order
        root.left = buildTreeHelper(preorder, inorder, rootValue);
        root.right = buildTreeHelper(preorder, inorder, stopValue);
        
        return root; // return the root of the constructed subtree
    }
}
