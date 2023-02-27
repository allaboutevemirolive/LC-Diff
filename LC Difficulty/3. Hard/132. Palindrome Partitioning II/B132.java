import java.util.Arrays;

class B132 {
    public int minCut(String s) {
        return expandAroundCenterWay(s);
    }

    int expandAroundCenterWay(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            dp[i] = i;
        }

        for (int mid = 0; mid < n; mid ++) {
            updateMinimumCuts(chars, mid, mid, dp);
            updateMinimumCuts(chars, mid - 1, mid, dp);
        }

        return dp[n - 1];
    }

    void updateMinimumCuts(char[] chars, int startIndex, int endIndex, int[] dp) {
        int n = chars.length;
        int start = startIndex;
        int end = endIndex;
        while (start >= 0 && end < n && chars[start] == chars[end]) {
            int newCuts = start == 0 ? 0 : 1 + dp[start - 1];
            dp[end] = Math.min(dp[end], newCuts);

            start --;
            end ++;
        }
    }

    int tabWay(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] dp = new int[n];
        boolean[][] palindromeMemo = new boolean[n][n];

        for (int end = 0; end < n; end ++) {
            int minimumCuts = end;
            for (int start = 0; start <= end; start ++) {
                if (chars[start] == chars[end] && (end - start <= 2 || palindromeMemo[start + 1][end - 1])) {
                    palindromeMemo[start][end] = true;
                    int cuts = start == 0 ? 0 : 1 + dp[start - 1];
                    minimumCuts = Math.min(minimumCuts, cuts);
                }
            }
            dp[end] = minimumCuts;
        }

        return dp[n - 1];
    }

    int recMemoWay(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        boolean[][] palindromeMemo = new boolean[s.length()][s.length()];
        return helper(s.toCharArray(), 0, memo, palindromeMemo);
    }

    int helper(char[] chars, int start, int[] memo, boolean[][] palindromeMemo) {
        int n = chars.length;
        if (start == n) return -1;

        if (memo[start] != -1) return memo[start];

        int cuts = Integer.MAX_VALUE;
        for (int end = start; end < n; end++) {
            if (chars[start] == chars[end] && (end - start <= 2 || palindromeMemo[start + 1][end - 1])) {
                palindromeMemo[start][end] = true;
                cuts = Math.min(cuts, 1 + helper(chars, end + 1, memo, palindromeMemo));
            }
        }

        return memo[start] = cuts;
    }

    boolean isPalindrome(char[] chars, int lo, int hi) {
        while (lo < hi) {
            if (chars[lo] != chars[hi]) return false;
            lo ++;
            hi --;
        }

        return true;
    }
}