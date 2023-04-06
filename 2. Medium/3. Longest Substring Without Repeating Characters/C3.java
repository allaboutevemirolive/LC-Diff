import java.util.Arrays;

public class C3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] lastSeen = new int[128]; // store the last index seen for each character
        Arrays.fill(lastSeen, -1); // initialize the array with -1
        int longestSubstringLength = 0;
        int startIndex = 0;
        for (int endIndex = 0; endIndex < n; endIndex++) {
            // move start index to the next character if the current character has already been seen
            startIndex = Math.max(startIndex, lastSeen[s.charAt(endIndex)] + 1);
            // update the last seen index of the current character
            lastSeen[s.charAt(endIndex)] = endIndex;
            // update the length of the longest substring
            longestSubstringLength = Math.max(longestSubstringLength, endIndex - startIndex + 1);
        }
        return longestSubstringLength;
    }
}