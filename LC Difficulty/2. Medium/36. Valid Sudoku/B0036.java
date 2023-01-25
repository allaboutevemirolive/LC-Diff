public class B0036 {
    
    public static boolean isValidSudoku(char[][] board) {
        // create an array of prime numbers to store the values that have already been seen
        int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23};
        
        // create variables to store the values that have already been seen in each row, column, and sub-box
        int t = 2*3*5*7*11*13*17*19*23;
        int[] quadrant = new int[] {t, t, t, t, t, t, t, t, t};
        int[] col = new int[] {t, t, t, t, t, t, t, t, t};
        
        // iterate over the cells in the board
        for (int x = 0; x < 9; x++) {
            int row = t;
            for (int y = 0; y < 9; y++) {
                // if the current cell is not empty
                if (board[x][y] != '.') {
                    // get the value of the current cell
                    int n = (int) board[x][y] - 48;
                    // get the prime number corresponding to the value of the current cell
                    int pn = primes[n-1];
                    // calculate the index of the sub-box that the current cell belongs to
                    int q = (x / 3) * 3 + (y / 3);
                    // check if the value of the current cell has already been seen in the current row, column, or sub-box
                    if (row % pn != 0 || col[y] % pn != 0 || quadrant[q] % pn != 0) return false;
                    // update the values stored in the row, column, and sub-box variables
                    row /= pn;
                    col[y] /= pn;
                    quadrant[q] /= pn;
                }
            }
        }
        // if no invalid value was found, the board is valid
        return true;
    }
}
