import java.util.List;

class A95 {
    public static void main(String[] args) {
        int numOfNodes = 3;
        C95 obj = new C95();
        List<T95> result = obj.generateTrees(numOfNodes);

        System.out.println("Input: n = " + numOfNodes);
        System.out.println("Output: ");
        for (T95 root : result) {
            printTree(root);
            System.out.println();
        }
    }

    private static void printTree(T95 root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

}