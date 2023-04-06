class C109 {
    public T109 sortedListToBST(L109 head) {
        // Check if the head of the linked list is null. If so, return null.
        if (head == null) {
            return null;
        }
        // Call the buildTree method with the head of the linked list and null to represent the end of the list.
        return buildTree(head, null);
    }
    
    private T109 buildTree(L109 start, L109 end) {
        // If the start and end nodes are the same, return null.
        if (start == end) {
            return null;
        }
        // Find the middle node of the linked list.
        L109 mid = findMiddleNode(start, end);
        // Create a new TreeNode using the value of the middle node.
        T109 root = new T109(mid.val);
        // Recursively build the left and right subtrees of the root node.
        root.left = buildTree(start, mid);
        root.right = buildTree(mid.next, end);
        // Return the root node of the tree.
        return root;
    }
    
    private L109 findMiddleNode(L109 start, L109 end) {
        // Use two pointers to find the middle node of the linked list.
        L109 slow = start;
        L109 fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Return the middle node.
        return slow;
    }
}
