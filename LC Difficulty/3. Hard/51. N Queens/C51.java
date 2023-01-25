import java.util.ArrayList;
import java.util.List;

class C51 {
    public List<List<String>> solveNQueens(int n) {
        // Initialize a list to store the solutions
        List<List<String>> res = new ArrayList<>();
        // Create a 2D char array to represent the chessboard
        char[][] board = new char[n][n];
        // Fill the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // Perform backtracking
        backtrack(res, board, 0);
        return res;
    }
    
    private void backtrack(List<List<String>> res, char[][] board, int row) {
        // Base case: if we have placed queens in all rows, add the current board configuration to the solutions
        if (row == board.length) {
            res.add(construct(board));
            return;
        }
        // Iterate through all columns in the current row
        for (int col = 0; col < board.length; col++) {
            // If the current position is valid
            if (isValid(board, row, col)) {
                // Place a queen in the current position
                board[row][col] = 'Q';                
                // Recursively search for solutions
                backtrack(res, board, row + 1);
                // Backtrack
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int row, int col) {
        // Check the same column for previous queens
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check the top-left diagonal for previous queens
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check the top-right diagonal for previous queens
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    
    private List<String> construct(char[][] board) {
        // Convert the 2D char array to a list of strings
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}

               
