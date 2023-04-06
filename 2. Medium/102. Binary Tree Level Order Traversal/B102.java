import java.util.ArrayList;
import java.util.List;

class B102 {
    // Creates a list of lists to store the values of each level in the binary tree
    public List<List<Integer>> levelOrder(T102 root) {
        List<List<Integer>> levels = new ArrayList<>();
        traverseLevelOrder(levels, root, 0);
        return levels;
    }

    // Recursive method to traverse the binary tree level-by-level
    private void traverseLevelOrder(List<List<Integer>> levels, T102 node, int level) {
        if (node != null) {
            // If the current level is equal to the size of the levels list,
            // create a new list for this level
            if (level == levels.size()) {
                levels.add(new ArrayList<>());
            }
            // Add the value of the current node to the list of values for this level
            levels.get(level).add(node.val);
            // Recursively call the traverseLevelOrder method for the left and right children
            traverseLevelOrder(levels, node.left, level + 1);
            traverseLevelOrder(levels, node.right, level + 1);
        }
    }
}
