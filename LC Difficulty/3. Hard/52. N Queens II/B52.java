class B52 {
    // variable to keep track of number of solutions found
    int count; 
    public int totalNQueens(int n) {
        // initialize count to 0
        count = 0; 
        // call backtrack function with initial bitmasks
        backtrack(0, 0, 0, 0, n); 
        // return the number of solutions found
        return count; 
    }
    private void backtrack(int row, int ld, int col, int rd, int n) {
        // if all rows are filled
        if (row == (1 << n) - 1) { 
            // increment count, a solution is found
            count++; 
            return;
        }
        // generate bitmask for empty positions
        int pos = (~(row | ld | col | rd)) & ((1 << n) - 1); 
        while (pos > 0) {
            // get lowest set bit in pos
            int p = pos & -pos; 
            // mark this position as filled
            pos -= p; 
            // recursive call with updated bitmasks
            backtrack((row | p), (ld | p) << 1, (col | p), (rd | p) >> 1, n); 
        }
    }
}
