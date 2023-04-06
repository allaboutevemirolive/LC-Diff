class C174 {
    int[][] dp;
    int rows, cols;

    public int calculateMinimumHP(int[][] A) {
        rows = A.length;
        cols = A[0].length;
        dp = new int[rows][cols];

        calculateMinimumHPHelper(A, 0, 0);
        return dp[0][0];
    }

    public int calculateMinimumHPHelper(int[][] A, int i, int j) {
        if (i >= rows || j >= cols) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        int leftPath = calculateMinimumHPHelper(A, i, j + 1);
        int rightPath = calculateMinimumHPHelper(A, i + 1, j);

        // Handling the only case which is the right bottom seperately.
        if (leftPath == Integer.MAX_VALUE && rightPath == Integer.MAX_VALUE) {
            dp[i][j] = A[i][j] > 0 ? 1 : Math.abs(A[i][j]) + 1;
            return dp[i][j];
        }

        int bestPath = Math.min(leftPath, rightPath);

        if (A[i][j] > 0) {
            dp[i][j] = Math.max(bestPath - A[i][j], 1);
        } else {
            dp[i][j] = Math.abs(A[i][j]) + bestPath;
        }

        return dp[i][j];
    }
}