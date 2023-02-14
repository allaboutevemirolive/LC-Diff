class B106 {
    // current index in postorder array
    private int postorderIndex; 
    // current index in inorder array
    private int inorderIndex;   

    public T106 buildTree(int[] inorder, int[] postorder) {
        // set initial indices to end of arrays
        postorderIndex = inorderIndex = inorder.length - 1; 
        // start building tree
        return buildTreeHelper(inorder, postorder, Integer.MAX_VALUE); 
    }

    private T106 buildTreeHelper(int[] inorder, int[] postorder, int stopValue) {
        // if all nodes have been processed or we've reached the stop value
        if (postorderIndex < 0 || inorder[inorderIndex] == stopValue) { 
            // move to the previous index in the inorder array
            inorderIndex--; 
            // return null as we've processed all nodes in the current subtree
            return null;   
        }

        // get the next node from the postorder array
        int rootValue = postorder[postorderIndex--]; 
        // create a new node for the current root value
        T106 root = new T106(rootValue);     
        // recursively build right subtree
        root.right = buildTreeHelper(inorder, postorder, rootValue); 
        // recursively build left subtree
        root.left = buildTreeHelper(inorder, postorder, stopValue);   
        // return the completed tree
        return root; 
    }
}
