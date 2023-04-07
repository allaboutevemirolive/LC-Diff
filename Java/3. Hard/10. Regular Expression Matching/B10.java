public class B10 {

    public static boolean isMatch(String s, String p) {
        // the length of the string s
        int m = s.length();

        // the length of the string p
        int n = p.length();

        // 2D boolean array to store the matching result
        boolean[][] dp = new boolean[m + 1][n + 1];

        // initializing the first element of the array as true
        dp[0][0] = true;

        // loop through the pattern string, 
        // check if the current character is '*' and
        // its previous element is true
        // if so, set the current element in the first row of the dp array as true
        for (int j = 1; j <= n; j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        // nested loop through the string s and the pattern p
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // check if the current character in the pattern is '*'
                if (p.charAt(j - 1) == '*') {
                    // check if the current character in the string matches 
                    // the previous character in the pattern or 
                    // the previous character in the pattern is '.'
                    dp[i][j] = dp[i][j - 2] 
                    || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) 
                    || p.charAt(j - 2) == '.'));
                } else {
                    // if the current character in the pattern is not '*', 
                    // check if the current character in the string matches 
                    // the current character in the pattern, or 
                    // the current character in the pattern is '.'
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) 
                    || p.charAt(j - 1) == '.');
                }
            }
        }
        // return the final matching result
        return dp[m][n];
    }

}
