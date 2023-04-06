import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class B87 {
    Map<String, Boolean> mem = new HashMap<>();

    // This function uses memoization to check if two strings are scramble of each other.
    public boolean isScramble(String s1, String s2) {
        // hash is a unique identifier for the given pair of strings
        var hash = s1 + s2;
        // check if the pair of strings is already processed
        if (!mem.containsKey(hash)) {
            // if not, process the pair of strings and store the result in the memoization table
            mem.put(hash, is(s1, s2));
        }
        // return the result from the memoization table
        return mem.get(hash);
    }

    private boolean is(String s1, String s2) {
        // if both strings are same then they are scramble of each other
        if (s1.equals(s2))
            return true;
        // count array stores the count of characters in the string
        int[] count = new int[26];
        int[] countF = new int[26];
        int[] countB = new int[26];
        for (int i = 0; i < s1.length() - 1; i++) {
            int j = s2.length() - 1 - i;
            // update the count array for the substring s1[0...i]
            count[s1.charAt(i) - 'a'] += 1;
            // update the countF array for the substring s2[0...i]
            countF[s2.charAt(i) - 'a'] += 1;
            // update the countB array for the substring s2[j...n-1]
            countB[s2.charAt(j) - 'a'] += 1;
            // check if count array and countF array are same
            if (Arrays.equals(count, countF)) {
                // if yes, check if s1[0...i] is scramble of s2[0...i] and s1[i+1...n-1] is scramble of s2[i+1...n-1]
                if (isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1)) && isScramble(s1.substring(i + 1), s2.substring(i + 1))) {
                    return true;
                }
            }
            // check if count array and countB array are same
            if (Arrays.equals(count, countB)) {
                // if yes, check if s1[0...i] is scramble of s2[j...n-1] and s1[i+1...n-1] is scramble of s2[0...j]
                if (isScramble(s1.substring(0, i + 1), s2.substring(j)) && isScramble(s1.substring(i + 1), s2.substring(0, j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
