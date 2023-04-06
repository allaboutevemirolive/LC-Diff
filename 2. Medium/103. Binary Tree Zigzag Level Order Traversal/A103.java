import java.util.List;

class A103 {
    public static void main(String[] args) {
        B103 obj = new B103();
        // Create a sample binary tree
        T103 root = new T103(3);
        root.left = new T103(9);
        root.right = new T103(20);
        root.right.left = new T103(15);
        root.right.right = new T103(7);
    
        // Traverse the tree and print its nodes in zigzag order
        List<List<Integer>> result = obj.zigzagLevelOrder(root);
        System.out.println(result);
    }
    
}
