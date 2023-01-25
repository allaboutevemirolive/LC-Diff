class B0076 {
    public String minWindow(String s, String t) {
        // Initialize an array to keep track of the frequency of each character in t
        int[] tMap = new int[128];
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }
        // Keep track of the number of unique characters in t
        int required = t.length();
        // Initialize pointers for the sliding window
        int left = 0, right = 0;
        // Keep track of the number of unique characters in the current window that are also in t
        int formed = 0;
        // Initialize an array to keep track of the frequency of each character in the current window
        int[] windowMap = new int[128];
        // Initialize an array to store the information of the smallest window that contains all characters in t
        int[] ans = {-1, 0, 0}; // {length, left, right}
        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap[c]++;
            // check if the current character is in T and the count of this character in window is less than or equal to T
            if (tMap[c] > 0 && windowMap[c] <= tMap[c]) {
                formed++;
            }
            // Shrink the window from the left
            while (left <= right && formed == required) {
                c = s.charAt(left);
                // update the ans if the current window is smaller than previous ans
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowMap[c]--;
                // check if the current character is in T and the count of this character in window is less than T
                if (tMap[c] > 0 && windowMap[c] < tMap[c]) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        // Return the smallest window that contains all characters in t, or an empty string if none is found
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
