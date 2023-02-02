import java.util.List;

class A95 {
    public static void main(String[] args) {
        int numOfNodes = 3;
        C95 obj = new C95();
        List<TreeNode> result = obj.generateTrees(numOfNodes);

        System.out.println("Input: n = " + numOfNodes);
        System.out.println("Output: ");
        for (TreeNode root : result) {
            printTree(root);
            System.out.println();
        }
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

}