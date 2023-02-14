// Import necessary libraries
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Define a class called Solution
class B103 {

    // Define the method zigzagLevelOrder that takes a T103 object as an argument and returns a list of list of integers
    public List<List<Integer>> zigzagLevelOrder(T103 root) {

        // If the root is null, return an empty ArrayList
        if (root == null) {
            return new ArrayList<>();
        }

        // Create a new ArrayList called result
        List<List<Integer>> result = new ArrayList<>();

        // Call the method traverseTree and pass the root, result, and initial level (0) as arguments
        traverseTree(root, result, 0);

        // Return the resulting list
        return result; 
    }

    // Define the helper method traverseTree that takes a T103 object, a list of list of integers, and a level as arguments
    private void traverseTree(T103 node, List<List<Integer>> result, int level) {

        // If the size of the result list is less than or equal to the current level or the current level is null
        if (result.size() <= level || result.get(level) == null) {

            // Add a new LinkedList to the result list
            result.add(new LinkedList<>());
        }

        // Get the list at the current level and store it in a LinkedList called currentLevelList
        LinkedList<Integer> currentLevelList = (LinkedList<Integer>) result.get(level);

        // If the level is even, add the node value to the end of the currentLevelList. Otherwise, add the node value to the beginning of the currentLevelList.
        if (level % 2 == 0) {
            currentLevelList.add(node.val);
        } else {
            currentLevelList.add(0, node.val);
        }

        // If the node has a left child, call traverseTree with the left child, the result list, and the next level as arguments
        if (node.left != null) {
            traverseTree(node.left, result, level+1);
        }

        // If the node has a right child, call traverseTree with the right child, the result list, and the next level as arguments
        if (node.right != null) {
            traverseTree(node.right, result, level+1);
        }
    }
}
