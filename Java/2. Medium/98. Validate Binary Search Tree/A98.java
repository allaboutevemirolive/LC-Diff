public class A98 {
    public static void main(String[] args) {
        T98 root = new T98(2, new T98(1), new T98(3));
        B98 bstValidator = new B98();
        System.out.println("Is the tree a valid BST: " + bstValidator.isValidBST(root));
    }

}
