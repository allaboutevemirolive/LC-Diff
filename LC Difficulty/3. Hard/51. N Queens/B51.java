import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class B51 {
  public List<List<String>> solveNQueens(int n) {
    // Initialize an empty list to store the solutions
    List<List<String>> ans = new ArrayList<>();
    // Create a 2D char array to represent the chessboard
    char[][] board = new char[n][n];

    // Fill the board with '.'
    for (int i = 0; i < n; ++i) {
      Arrays.fill(board[i], '.');
    }

    // Perform depth first search
    dfs(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], board, ans);
    return ans;
  }

  private void dfs(int n, int i, boolean[] cols, boolean[] diag1, boolean[] diag2, char[][] board,
      List<List<String>> ans) {
    // Base case: if we have placed queens in all rows, add the current board
    // configuration to the solutions
    if (i == n) {
      ans.add(construct(board));
      return;
    }

    // Iterate through all columns in the current row
    for (int j = 0; j < cols.length; ++j) {
      // If the current position is not valid (col, diagonal1 or diagonal2 is already
      // occupied by a queen)
      if (cols[j] || diag1[i + j] || diag2[j - i + n - 1])
        continue;
      // Place a queen in the current position
      board[i][j] = 'Q';
      // Mark the current position as occupied
      cols[j] = diag1[i + j] = diag2[j - i + n - 1] = true;
      // Recursively search for solutions
      dfs(n, i + 1, cols, diag1, diag2, board, ans);
      // Backtrack
      cols[j] = diag1[i + j] = diag2[j - i + n - 1] = false;

      board[i][j] = '.';
    }
  }

  private List<String> construct(char[][] board) {
    // Convert the 2D char array to a list of strings
    List<String> listBoard = new ArrayList<>();
    for (int i = 0; i < board.length; ++i)
      listBoard.add(String.valueOf(board[i]));
    return listBoard;
  }

public int totalNQueens(int n) {
    return 0;
}

public int maxSubArray(int[] nums) {
    return 0;
}
}
