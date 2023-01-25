import java.util.Arrays;

public class B0003 {
    
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        // use an array to store the last occurrence of each character
        int[] last = new int[128];
        Arrays.fill(last, -1);
        int ans = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            // if the current character has been seen before, update the left pointer to the last occurrence + 1
            i = Math.max(i, last[s.charAt(j)] + 1);
            // update the last occurrence of the current character
            last[s.charAt(j)] = j;
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
