import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class C106 {
    public T106 buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return null;
        
        // Create a map to store the index of each node in the inorder array
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            indexMap.put(inorder[i], i);

        // Create the root node and push it onto the stack
        int n = inorder.length;
        T106 root = new T106(postorder[n - 1]);
        Deque<T106> stack = new LinkedList<>();
        stack.push(root);

        // Traverse the postorder array from right to left
        for (int i = n - 2; i >= 0; i--) {
            T106 curr = new T106(postorder[i]);
            T106 parent = null;

            // Keep popping nodes from the stack until we find the parent of the current node
            while (!stack.isEmpty() && indexMap.get(postorder[i]) < indexMap.get(stack.peek().val)) {
                parent = stack.pop();
            }

            // If the parent node exists, set the current node as its left child
            if (parent != null) {
                parent.left = curr;
            } else {
                // Otherwise, set the current node as the right child of the node at the top of the stack
                stack.peek().right = curr;
            }

            // Push the current node onto the stack
            stack.push(curr);
        }

        return root;
    }
}