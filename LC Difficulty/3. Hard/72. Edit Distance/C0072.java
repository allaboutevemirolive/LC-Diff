import java.util.Arrays;

class B0072 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // create a 2D array to store intermediate results
        int[][] dp = new int[n][m];
        // fill array with -1 to mark as uncalculated
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(word1, word2, n - 1, m - 1, dp);
    }

    // function to calculate the minimum edit distance
    public int fun(String s1, String s2, int i, int j, int[][] dp) {
        // base case, when one string ends, the min # op is the len of the other string
        // left
        if (i < 0)
            return j + 1; // return 0, 
        if (j < 0)
            return i + 1; // return 0，

        // check memo to prevent duplicated calculations
        if (dp[i][j] != -1)
            return dp[i][j];

        // if current character of both strings are equal
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 0 + fun(s1, s2, i - 1, j - 1, dp);
            return dp[i][j];
        } else {
            // calculate minimum edit distance for insertion, deletion and replacement
            int insert = 1 + fun(s1, s2, i, j - 1, dp);
            int delete = 1 + fun(s1, s2, i - 1, j, dp);
            int replace = 1 + fun(s1, s2, i - 1, j - 1, dp);

            // store the minimum of the three operations in the dp array
            dp[i][j] = Math.min(insert, Math.min(delete, replace));

            return dp[i][j];
        }
    }
}
