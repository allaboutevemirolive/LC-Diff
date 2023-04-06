import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B472 {
    // set to store all the words in the dictionary
    Set<String> set = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // list to store the concatenated words that are found
        List<String> answer = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        //iterate through the input array of words
        for (String word : words) {
            if (word.length() != 0)
                set.add(word);
            // keep track of the minimum length of any word in the dictionary
            min = Math.min(min, word.length());
        }

        for (String word : words) {
            // call the concat method to check if the word is a concatenation of other words in the dictionary
            if (concat(word, 0, word.length(), min))
                answer.add(word);
        }
        return answer;
    }

    private boolean concat(String word, int start, int end, int min) {
        // iterate through the word, starting at the minimum length of any word in the dictionary
        for (int i = start + min; i <= end - min; i++) {
            // check if the substring from start to i is in the dictionary
            if (set.contains(word.substring(start, i))
                    // check if the substring from i to end is in the dictionary or is a concatenation of other words in the dictionary
                    && (set.contains(word.substring(i, end)) || concat(word, i, end, min))) {
                return true;
            }
        }
        return false;
    }
}
