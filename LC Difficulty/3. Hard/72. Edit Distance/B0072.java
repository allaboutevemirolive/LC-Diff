class B0072 {
    public int minDistance(String word1, String word2) {
        int n = word1.length(); // length of first string
        int m = word2.length(); // length of second string

        // create a 1D array to store intermediate results
        int[] dp = new int[m + 1];

        // initialize the first column with 0,1,2,...,m
        for (int i = 0; i <= m; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            int prev = dp[0]; // store previous value
            dp[0] = i;  // update first column
            for (int j = 1; j <= m; j++) {
                int temp = dp[j]; 
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev; // if the characters are equal, no operation is needed
                } else {
                    // calculate minimum edit distance for insertion, deletion and replacement
                    dp[j] = 1 + Math.min(Math.min(dp[j - 1], dp[j]), prev);
                }
                prev = temp; 
            }
        }
        return dp[m]; // return the minimum edit distance
    }
}
