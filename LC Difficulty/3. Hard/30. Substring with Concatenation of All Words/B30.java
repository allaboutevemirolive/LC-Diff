import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        // initialize variables
        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;
        Map<String, Integer> hash = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        char[] s2 = s.toCharArray();

        // map each string in words to a unique integer
        for (String value : words) {
            hash.putIfAbsent(value, hash.size());
        }
        // create an array count
        int[] count = new int[hash.size()];
        for (String word : words) {
            count[hash.get(word)]++;
        }

        // outer loop, iterate i from 0 to wordLength
        for (int i = 0; i < wordLength; i++) {
            // inner loop, iterate j from i to s.length() - totalWordsLength with step wordLength
            for (int j = i; j <= s.length() - totalWordsLength; j += wordLength) {
                // create a localCount array with the same size as hash
                int[] localCount = new int[hash.size()];
                //inner most loop, iterate k from j + totalWordsLength - wordLength to j
                for (int k = j + totalWordsLength - wordLength; k >= j; k -= wordLength) {
                    String str = new String(s2, k, wordLength);     // [ k, k+wordLength )
                    Integer key = hash.get(str);

                    // increment the count of the word in localCount
                    if (!(key != null && count[key] >= ++localCount[key])) {
                        // if word count in count is greater than local count then break inner loop
                        j = k;
                        break;
                    }
                    if (j == k) {
                        // if the inner loops complete without breaking, then add j to ans
                        ans.add(j);
                    }
                }
            }
        }
        return ans;
    }
}
