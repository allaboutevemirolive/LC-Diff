class D132 {
    int[] dp;

    public int minCut(String s) {
        int len = s.length();

        // initialize an array for storing minimum cuts needed for each substring
        dp = new int[len];
        for (int i = 0; i < len; ++i)
            dp[i] = i;

        // loop through each character in s
        for (int i = 0; i < len; ++i) {
            // check if current character and its neighbor are the same character
            isPal(s, i, i);
            isPal(s, i, i + 1);
        }

        // return the minimum cuts needed for the whole string s
        return dp[len - 1];
    }

    // helper function to check if a substring is a palindrome
    private void isPal(String s, int i, int j) {
        while (i > -1 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            // if the current substring is a palindrome, 
            // update the minimum cut for the current end index j
            int temp = i == 0 ? 0 : dp[i - 1] + 1;
            dp[j] = Math.min(dp[j], temp);
            // check the next pair of characters in the substring
            --i;
            ++j;
        }
    }
}