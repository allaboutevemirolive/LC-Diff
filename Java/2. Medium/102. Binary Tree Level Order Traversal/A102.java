import java.util.List;

class A102 {
    public static void main(String[] args) {
        T102 root = new T102(3);
        root.left = new T102(9);
        root.right = new T102(20);
        root.right.left = new T102(15);
        root.right.right = new T102(7);

        B102 obj = new B102();
        List<List<Integer>> levels = obj.levelOrder(root);

        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }
}
