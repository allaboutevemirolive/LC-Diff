public class B0005 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        String t = sb.toString();
        int n = t.length();
        int[] p = new int[n];
        int center = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            int left = i - (1 + p[i]);
            int rightBoundary = i + (1 + p[i]);
            while (left >= 0 && rightBoundary < n && t.charAt(left) == t.charAt(rightBoundary)) {
                p[i]++;
                left--;
                rightBoundary++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
