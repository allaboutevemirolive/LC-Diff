class B109 {
    public T109 sortedListToBST(L109 head) {
        // If the linked list is empty, return null.
        if (head == null) {
            return null;
        }
        // If the linked list has only one node, create a new tree node with its value and return it.
        if (head.next == null) {
            return new T109(head.val);
        }
        // Use two pointers to find the middle node of the linked list.
        L109 slow = head; // Moves one node at a time.
        L109 fast = head; // Moves two nodes at a time.
        L109 prev = null; // Keeps track of the node before the middle node.
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // The middle node is the root of the binary search tree.
        T109 root = new T109(slow.val);
        // Split the linked list into two halves, left and right, at the middle node.
        if (prev != null) {
            prev.next = null;
        }
        // Recursively build the left and right subtrees.
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        // Return the root of the binary search tree.
        return root;
    }  
}
