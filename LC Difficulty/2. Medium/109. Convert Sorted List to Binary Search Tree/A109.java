class A109 {
    public static void main(String[] args) {
        // Create a sorted linked list.
        L109 head = new L109(-10);
        head.next = new L109(-3);
        head.next.next = new L109(0);
        head.next.next.next = new L109(5);
        head.next.next.next.next = new L109(9);

        // Convert the sorted linked list to a binary search tree.
        B109 obj = new B109();
        T109 root = obj.sortedListToBST(head);

        // Print the binary search tree.
        printTree(root);
    }

    private static void printTree(T109 node) {
        if (node == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }

}
