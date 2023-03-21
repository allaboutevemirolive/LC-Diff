public class A297 {
    public static void main(String[] args) {
        // Construct a sample binary tree
        T297 root = new T297(1);
        root.left = new T297(2);
        root.right = new T297(3);
        root.right.left = new T297(4);
        root.right.right = new T297(5);
    
        // Serialize the binary tree to a string
        B297 codec = new B297();
        String serialized = codec.serialize(root);
        System.out.println("Serialized tree: " + serialized);
    
        // Deserialize the string back to a binary tree
        T297 deserialized = codec.deserialize(serialized);
    
        // Verify that the deserialized tree is the same as the original tree
        boolean isEqual = isSameTree(root, deserialized);
        System.out.println("Deserialized tree is the same as the original tree: " + isEqual);
    }
    
    // Helper function to check if two binary trees are identical
    public static boolean isSameTree(T297 p, T297 q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
}
