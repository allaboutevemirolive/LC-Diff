public class B0044 {

    public boolean isMatch(String s, String p) {
        // edge case: if p is empty, s must also be empty for a match
        if (p.isEmpty())
            return s.isEmpty();

        // dp[j] is true if s[0..i) and p[0..j) match
        boolean[] dp = new boolean[p.length() + 1];
        dp[0] = true;

        // handle cases where p starts with '*'
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 1];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            boolean prev = dp[0];
            dp[0] = false;
            for (int j = 1; j <= p.length(); j++) {
                char c1 = s.charAt(i - 1);
                char c2 = p.charAt(j - 1);
                boolean tmp = dp[j];
                if (c2 == '?' || c1 == c2) {
                    dp[j] = prev;
                } else if (c2 == '*') {
                    dp[j] = dp[j - 1] || dp[j];
                } else {
                    dp[j] = false;
                }
                prev = tmp;
            }
        }

        return dp[p.length()];
    }

}
