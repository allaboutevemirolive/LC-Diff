import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class D102 {
    // Returns the level order traversal of a binary tree
    public List<List<Integer>> levelOrder(T102 root) {
        // Initialize an ArrayList to store the result
        List<List<Integer>> result = new ArrayList<>();
        // If the root is null, return an empty result
        if (root == null) {
            return result;
        }

        // Create a queue to store nodes in the current level
        Queue<T102> nodesQueue = new LinkedList<>();
        nodesQueue.offer(root);

        // While the queue is not empty, process nodes in the current level
        while (!nodesQueue.isEmpty()) {
            // Get the number of nodes in the current level
            int currentLevelNodeCount = nodesQueue.size();
            // Create a list to store the values of nodes in the current level
            List<Integer> currentLevelValues = new ArrayList<>(currentLevelNodeCount);
            // Process nodes in the current level
            for (int i = 0; i < currentLevelNodeCount; i++) {
                // Dequeue a node from the queue
                T102 currentNode = nodesQueue.poll();
                // Add the value of the node to the current level values list
                currentLevelValues.add(currentNode.val);
                // If the node has a left child, add it to the queue
                if (currentNode.left != null) {
                    nodesQueue.offer(currentNode.left);
                }
                // If the node has a right child, add it to the queue
                if (currentNode.right != null) {
                    nodesQueue.offer(currentNode.right);
                }
            }
            // Add the current level values list to the result
            result.add(currentLevelValues);
        }
        return result;
    }
}
