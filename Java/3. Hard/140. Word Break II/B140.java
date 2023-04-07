import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class B140 {
    private Set<String> wordSet; // stores the words in the dictionary
    private List<String>[] memo; // memoization array to store previously computed results

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict); // initialize the set with the words in the dictionary
        memo = new List[s.length() + 1]; // initialize the memoization array
        memo[s.length()] = new ArrayList<>(); // add an empty string to the end of the memoization array
        memo[s.length()].add("");
        findWordBreaks(0, s); // start the recursive function to find word breaks in the input string
        return memo[0]; // return the list of word breaks for the entire input string
    }

    private List<String> findWordBreaks(int startIndex, String s) {
        if (memo[startIndex] != null) { // if the list of word breaks for the current index has already been computed
            return memo[startIndex]; // return the previously computed list of word breaks
        }

        memo[startIndex] = new ArrayList<>(); // create a new list of word breaks for the current index
        for (int i = startIndex; i < s.length(); i++) {
            String word = s.substring(startIndex, i + 1); // extract the substring from the current index to the current character
            if (wordSet.contains(word)) { // if the extracted substring is a valid word in the dictionary
                List<String> tails = findWordBreaks(i + 1, s); // find the word breaks in the remaining substring
                for (String tail : tails) {
                    if (tail.isEmpty()) { // if the tail is an empty string
                        memo[startIndex].add(word); // add the current word to the list of word breaks for the current index
                    } else { // if the tail is not an empty string
                        StringBuilder sb = new StringBuilder();
                        sb.append(word);
                        sb.append(" ");
                        sb.append(tail);
                        memo[startIndex].add(sb.toString()); // add the current word and the tail to the list of word breaks for the current index
                    }
                }
            }
        }

        return memo[startIndex]; // return the list of word breaks for the current index
    }
}
