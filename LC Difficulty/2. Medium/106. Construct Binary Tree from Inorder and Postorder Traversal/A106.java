public class A106 {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
    
        // Recursive approach
        B106 b106 = new B106();
        T106 rootRecursive = b106.buildTree(inorder, postorder);
        System.out.println("Recursive approach:");
        printTree(rootRecursive);
    
        System.out.println();
        // Iterative approach
        C106 c106 = new C106();
        T106 rootIterative = c106.buildTree(inorder, postorder);
        System.out.println("Iterative approach:");
        printTree(rootIterative);
    }
    
    private static void printTree(T106 root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
    
}
