import java.util.ArrayList;
import java.util.List;

class B0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Initialize an empty list to store the output
        List<Integer> result = new ArrayList<>();
        // Check if the input matrix is null or has no elements
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        // Get the number of rows and columns in the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        // Initialize variables to keep track of the current row and column boundaries
        int rowStart = 0;
        int rowEnd = m - 1;
        int colStart = 0;
        int colEnd = n - 1;
        // Loop until all rows and columns have been traversed
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse the current row from left to right
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            // Move to the next row
            rowStart++;
            // Traverse the current column from top to bottom
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            // Move to the previous column
            colEnd--;
            // Check if the current row has not been traversed
            if (rowStart <= rowEnd) {
                // Traverse the current row from right to left
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                // Move to the previous row
                rowEnd--;
            }
            // Check if the current column has not been traversed
            if (colStart <= colEnd) {
                // Traverse the current column from bottom to top
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
                // Move to the next column
                colStart++;
            }
        }
        return result;
    }
}
