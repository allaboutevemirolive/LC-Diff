import java.util.ArrayList;
import java.util.List;

class B95 {
    List<TreeNode>[][] memo;

    // main function which returns all possible binary trees using nodes from 1 to numOfNodes
    public List<TreeNode> generateTrees(int numOfNodes) {
        // memoization array to store previously computed results to save time
        memo = (List<TreeNode>[][]) new List[numOfNodes + 1][numOfNodes + 1];
        // call helper function to generate trees in the range 1 to numOfNodes
        return generateTreesInRange(1, numOfNodes);
    }

    // helper function to generate trees in the range startNode to endNode
    private List<TreeNode> generateTreesInRange(int startNode, int endNode) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        // if startNode is greater than endNode, then return a list with single null
        // node as this range can't have any node
        if (startNode > endNode) {
            result.add(null);
            return result;
        }

        // if result for the given range is already computed, then return it without
        // recomputing
        if (memo[startNode][endNode] != null) {
            return memo[startNode][endNode];
        }

        // loop through all nodes in the range startNode to endNode to find the root of each tree
        for (int i = startNode; i <= endNode; i++) {
            // generate all left subtrees for node i
            List<TreeNode> leftSubtrees = generateTreesInRange(startNode, i - 1);
            // generate all right subtrees for node i
            List<TreeNode> rightSubtrees = generateTreesInRange(i + 1, endNode);
            // for each combination of left and right subtrees, create a new tree
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        // store the result of the current range in memoization array to use later
        memo[startNode][endNode] = result;
        return result;
    }
}