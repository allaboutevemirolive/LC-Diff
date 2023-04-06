import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// DFS
class B107 {
    public List<List<Integer>> levelOrderBottom(T107 root) {
        // Create a list to hold the level-order traversal of the tree
        List<List<Integer>> result = new ArrayList<>();
        
        // Call the recursive helper function to traverse the tree and populate the list
        traverseTree(root, result, 0);
        
        // Reverse the list to obtain the bottom-up level order traversal
        Collections.reverse(result);
        return result;
    }

    public void traverseTree(T107 root, List<List<Integer>> result, int level) {
        // Base case: if the root is null, return from the function
        if (root == null) {
            return;
        }
        
        // If the list does not have a sublist for the current level, create one
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        
        // Add the value of the current root to the sublist for the current level
        result.get(level).add(root.val);
        
        // Recursively traverse the left and right subtrees, incrementing the level each time
        traverseTree(root.left, result, level + 1);
        traverseTree(root.right, result, level + 1);
    }
}
