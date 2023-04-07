class B79 {
    public boolean exist(char[][] board, String word) {

        int flag = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                    flag++;
                else if (board[i][j] == word.charAt(word.length() - 1))
                    flag--;
            }
        }
        // reduce the choices of the first letter of the word in the board
        if (flag > 0)
            word = new StringBuilder(word).reverse().toString();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper_backtrack(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    int[][] pos = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private boolean helper_backtrack(char[][] board, String word, int idx, int i, int j) {

        if (word.charAt(idx) != board[i][j])
            return false;
        if (idx == word.length() - 1)
            return true;
        char c = board[i][j];
        board[i][j] = '#';
        for (int[] p : pos) {
            int x = i + p[0], y = j + p[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
                continue;

            if (idx + 1 < word.length() && board[x][y] == word.charAt(idx + 1))
                if (helper_backtrack(board, word, idx + 1, x, y))
                    return true;

        }
        board[i][j] = c;
        return false;
    }
}
