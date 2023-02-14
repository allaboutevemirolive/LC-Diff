import java.util.List;

class A107 {
    public static void main(String[] args) {
        T107 root = new T107(3);
        root.left = new T107(9);
        root.right = new T107(20);
        root.right.left = new T107(15);
        root.right.right = new T107(7);
    
        B107 obj = new B107();
        List<List<Integer>> result = obj.levelOrderBottom(root);
        System.out.println(result);
    }
    
}
