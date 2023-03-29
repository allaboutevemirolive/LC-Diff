class B329 {
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = dfs(matrix, Integer.MIN_VALUE, i, j, m, n, cache);
                res = Math.max(max, res);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int pre, int i, int j, int m, int n, int[][] cache) {
        // check if out of bound or current matrix value is smaller than previous calculated value
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] <= pre) {
            return 0;
        }
        // check if already visited
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        pre = matrix[i][j];
        // check row above
        int a = dfs(matrix, pre, i - 1, j, m, n, cache) + 1;
        // check row below
        int b = dfs(matrix, pre, i + 1, j, m, n, cache) + 1;
        // check column left
        int c = dfs(matrix, pre, i, j - 1, m, n, cache) + 1;
        // check column right
        int d = dfs(matrix, pre, i, j + 1, m, n, cache) + 1;

        cache[i][j] = Math.max(a, Math.max(b, Math.max(c, d)));
        return cache[i][j];
    }
}