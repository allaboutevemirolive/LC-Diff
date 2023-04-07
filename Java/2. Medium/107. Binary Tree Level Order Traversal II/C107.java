import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BFS
class C107 {
    public List<List<Integer>> levelOrderBottom(T107 root) {
        // Initialize an empty list to hold the results
        List<List<Integer>> results = new ArrayList<>();

        if (root == null) {
            // If the root is null, return the empty results list
            return results;
        }

        // Initialize a queue to hold the nodes to be visited
        Queue<T107> queue = new LinkedList<>();
        // Add the root node to the queue
        queue.offer(root);

        while (!queue.isEmpty()) {
            // Get the number of nodes in the current level
            int levelSize = queue.size();
            // Initialize a list to hold the values of the nodes in the current level
            List<Integer> levelNodes = new ArrayList<>();

            // Traverse all nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                // Remove the first node from the queue
                T107 node = queue.poll();
                // Add the value of the node to the list of nodes in the current level
                levelNodes.add(node.val);

                // Add the left child of the node to the queue if it exists
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // Add the right child of the node to the queue if it exists
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Add the list of nodes in the current level to the beginning of the results list
            results.add(0, levelNodes);
        }

        // Return the results list
        return results;
    }
}
