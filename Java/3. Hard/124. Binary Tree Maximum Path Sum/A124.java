class A124 {
    public static void main(String[] args) {
        // Create the binary tree [1,2,3]
        T124 root = new T124(1);
        root.left = new T124(2);
        root.right = new T124(3);

        // Calculate the maximum path sum of the binary tree
        B124 obj = new B124();
        int maxPathSum = obj.maxPathSum(root);

        // Print the result
        System.out.println(maxPathSum); // Output: 6
    }
}
