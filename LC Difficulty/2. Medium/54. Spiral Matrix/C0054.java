import java.util.ArrayList;
import java.util.List;

class C0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        
        int m = matrix.length, n = matrix[0].length;
        int rowStart = 0, colStart = 0, rowEnd = m - 1, colEnd = n - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) result.add(matrix[rowStart][i]);
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) result.add(matrix[i][colEnd]);
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) result.add(matrix[rowEnd][i]);
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) result.add(matrix[i][colStart]);
                colStart++;
            }
        }
        return result;
    }
}