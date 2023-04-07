import java.util.ArrayList;
import java.util.List;

class C95 {
    // Function to generate all unique BST's given n nodes
    public List<T95> generateTrees(int n) {
        // If n is 0, return an empty list
        if (n == 0) {
            return new ArrayList<>();
        }
        // Call the helper function to generate the BST's
        return generateUniqueBST(1, n);
    }

    // Helper function to generate unique BST's
    private List<T95> generateUniqueBST(int start, int end) {
        // Initialize the list to store the generated BST's
        List<T95> uniqueBSTList = new ArrayList<>();
        // If start is greater than end, add null to the list and return
        if (start > end) {
            uniqueBSTList.add(null);
            return uniqueBSTList;
        }

        // Loop from start to end
        for (int i = start; i <= end; i++) {
            // Generate BST's with left subtree using values from start to i - 1
            List<T95> leftBSTList = generateUniqueBST(start, i - 1);
            // Generate BST's with right subtree using values from i + 1 to end
            List<T95> rightBSTList = generateUniqueBST(i + 1, end);
            // Loop through each left and right BST, and generate the current BST by combining them
            for (T95 leftBST : leftBSTList) {
                for (T95 rightBST : rightBSTList) {
                    T95 currBST = new T95(i);
                    // Set the left and right child of the current BST
                    currBST.left = leftBST;
                    currBST.right = rightBST;
                    // Add the current BST to the list
                    uniqueBSTList.add(currBST);
                }
            }
        }
        // Return the list of unique BST's
        return uniqueBSTList;
    }
}
