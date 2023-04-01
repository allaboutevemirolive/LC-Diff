import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class C336 {
    public List<List<Integer>> palindromePairs(String[] words) {

        // Initialize an empty list to store palindrome pairs
        List<List<Integer>> res = new ArrayList<>();

        // Initialize a HashMap to map each word to its index in the words array
        HashMap<String, Integer> map = new HashMap<>();

        // Initialize a boolean array to keep track of word lengths that appear in the words array
        boolean[] dict = new boolean[5001];

        // Initialize a counter to keep track of the index of each word in the words array
        int cnt = 0;

        // Iterate through each word in the words array
        for (String word : words) {

            // Map the word to its index in the words array
            map.put(word, cnt);

            // Increment the counter
            cnt++;

            // Mark the length of the word as true in the boolean array
            dict[word.length()] = true;
        }

        // Iterate through each word in the words array
        for (int i = 0; i < words.length; i++) {

            // Get the current word
            String word = words[i];

            // Check if the length of the word is greater than 0
            if (word.length() > 0) {

                // Convert the word to a char array
                char[] ch = word.toCharArray();

                // Reverse the current word
                String re = new StringBuilder(word).reverse().toString();

                // Iterate through each character of the current word, except the last character
                for (int j = 0; j < ch.length - 1; j++) {

                    // Check if there exists a word in the words array whose length is j+1 and the substring of the current word from index j+1 to the end is a palindrome
                    if (dict[j + 1] && isPalindrome(ch, j + 1, ch.length - 1)) {

                        // Get the substring of the reversed current word from index ch.length - j - 1 to ch.length
                        String check = re.substring(ch.length - j - 1, ch.length);

                        // Check if the substring exists in the HashMap
                        if (map.containsKey(check)) {

                            // Add the indices of the current word and the word found in the HashMap to the result list
                            res.add(Arrays.asList(i, map.get(check)));
                        }
                    }
                }

                // Iterate through each character of the current word, except the first character
                for (int j = 0; j < ch.length - 1; j++) {

                    // Check if there exists a word in the words array whose length is ch.length - j - 1 and the substring of the current word from index 0 to j is a palindrome
                    if (dict[ch.length - j - 1] && isPalindrome(ch, 0, j)) {

                        // Get the substring of the reversed current word from index 0 to ch.length - j - 1
                        String check = re.substring(0, ch.length - j - 1);

                        // Check if the substring exists in the HashMap
                        if (map.containsKey(check)) {

                            // Add the indices of the word found in the HashMap and the current word to the result list
                            res.add(Arrays.asList(map.get(check), i));
                        }
                    }
                }
                // Check if the current word itself is a palindrome
                if (isPalindrome(ch, 0, ch.length - 1)) {
                    if (map.containsKey("")) {
                        int index = map.get("");
                        res.add(Arrays.asList(index, i));
                        res.add(Arrays.asList(i, index));
                    }
                } else if (map.containsKey(re)) {
                    res.add(Arrays.asList(i, map.get(re)));
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(char[] ch, int left, int right) {
        // iterate through the characters from the left and right ends of the string until they meet in the middle
        while (left < right) {
            // if the characters at the left and right indices are not the same, then the string is not a palindrome
            if (ch[left] != ch[right]) {
                return false;
            }
            // increment the left index and decrement the right index to move towards the middle of the string
            left++;
            right--;
        }
        // if all the characters have been compared and are the same, then the string is a palindrome
        return true;
    }
}