public class A105 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
    
        B105 obj = new B105();
        T105 root = obj.buildTree(preorder, inorder);
    
        // print the inorder traversal of the constructed tree for verification
        printInorder(root);
    }

    private static void printInorder(T105 node) {
        if (node == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(node.val + " ");
        printInorder(node.left);
        printInorder(node.right);
    }


}
