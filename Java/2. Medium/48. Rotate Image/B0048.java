public class B0048 {
    
    public void rotate(int[][] matrix) {
        // Check if the matrix is empty or has only one element
        if (matrix == null || matrix.length <= 1) {
            return;
        }
    
        int n = matrix.length;
    
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    
        // Reverse the elements in each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
