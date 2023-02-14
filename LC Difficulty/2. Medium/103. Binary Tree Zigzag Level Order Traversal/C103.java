import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class C103 {
    public List<List<Integer>> zigzagLevelOrder(T103 root) {
        // Create an empty list to store the final result
        List<List<Integer>> result = new ArrayList<>();
        // Call the recursive function to traverse the tree and populate the result list
        traverseLevelOrder(root, result, 0);
        // Return the final result
        return result;
    }

    void traverseLevelOrder(T103 currentNode, List<List<Integer>> result, int level) {
        // If we have reached the end of a branch (i.e., a null node), return to the previous level
        if (currentNode == null) {
            return;
        }
        // If we are encountering a new level that hasn't been seen before, add it to the result list
        if (result.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            result.add(newLevel);
        }
        // Get the list that corresponds to the current level
        List<Integer> currentLevel = result.get(level);
        // Add the current node's value to the current level, either at the end or the beginning depending on whether the level is even or odd
        if (level % 2 == 0) {
            currentLevel.add(currentNode.val);
        } else {
            currentLevel.add(0, currentNode.val);
        }
        // Recursively traverse the left and right subtrees at the next level
        traverseLevelOrder(currentNode.left, result, level + 1);
        traverseLevelOrder(currentNode.right, result, level + 1);
    }
}