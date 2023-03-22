
// B297.java
public class A297 {
    public static void main(String[] args) {
        // Construct a sample binary tree
        T297 root = new T297(1);
        root.left = new T297(2);
        root.right = new T297(3);
        root.right.left = new T297(4);
        root.right.right = new T297(5);
    
        // Serialize the binary tree to a string
        C297 codec = new C297();
        String serialized = codec.serialize(root);
        System.out.println("Serialized tree: " + serialized);
    
        // Deserialize the string back to a binary tree
        T297 deserialized = codec.deserialize(serialized);
        // Convert the deserialized binary tree back to a string
        String serialized2 = codec.serialize(deserialized);
        System.out.println("Serialized tree: " + serialized2);
    
        // Verify that the deserialized tree is the same as the original tree
        boolean isEqual = isSameTree(root, deserialized);
        System.out.println("Deserialized tree is the same as the original tree: " + isEqual);
    }
    
    // Helper function to check if two binary trees are identical
    public static boolean isSameTree(T297 p, T297 q) {
        // Base case: both nodes are null
        if (p == null && q == null) {
            return true;
        }
        // Base case: one of the nodes is null
        if (p == null || q == null) {
            return false;
        }
        // Recursive case: check if the values are equal and the left and right subtrees are equal
        // Note that we need to use "&&" instead of "||" because we want to make sure that both subtrees are equal
        // If we use "||", then the function will return true as long as one of the subtrees is equal
        // For example, the following trees are not equal, but the function will return true because the left subtrees are equal
        //    1         1
        //  / \       / \
        // 2   3     2   3
        //    /       \
        //   4         4
        //  /           \
        // 5             5
        // But if we use "&&", the function will return false because the right subtrees are not equal
        //   1         1
        //  / \       / \
        // 2   3     2   3
        //    /       \
        //   4         4
        //  /           \
        // 5             6
        
        return p.val == q.val 
        && isSameTree(p.left, q.left) 
        && isSameTree(p.right, q.right);
    }
    
}
