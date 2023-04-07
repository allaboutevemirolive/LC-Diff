public class A99 {
    public static void main(String[] args) {
        T99 root = new T99(3);
        root.left = new T99(1);
        root.right = new T99(4);
        root.right.left = new T99(2);
    
        B99 b99 = new B99();
        b99.recoverTree(root);
    
        System.out.println("Output: " + root.val + ", " + root.left.val + ", " + root.right.val + ", " + root.right.left.val);
    }
}
