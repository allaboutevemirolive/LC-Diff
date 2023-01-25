class C {
    int count;
    
    public int totalNQueens(int n) {
        count = 0;
        int[] queens = new int[n];
        backtrack(queens, n, 0);
        return count;
    }
    
    private void backtrack(int[] queens, int n, int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                backtrack(queens, n, row + 1);
            }
        }
    }
    
    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            int pos = queens[i];
            if (pos == col) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(col - pos)) {
                return false;
            }
        }
        return true;
    }
}