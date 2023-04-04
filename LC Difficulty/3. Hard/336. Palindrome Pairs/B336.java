import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
// F336.java
// E336.java
// G336.java
class B336 {
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> res = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        boolean[] dict = new boolean[5001];
        int cnt = 0;
        for (String word : words) {
            map.put(word, cnt);
            cnt++;
            dict[word.length()] = true;
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            //Base case: "s" is 0 initial position. Can't check so skip.
            if (word.length() > 0) {
                char[] ch = word.toCharArray();
                String re = new StringBuilder(word).reverse().toString();

                // Not sure what test case should be included but you can refer to the next comment
                for (int j = 0; j < ch.length - 1; j++) {

                    if (dict[j + 1] && isPalindrome(ch, j + 1, ch.length - 1)) {
                        String check = re.substring(ch.length - j - 1, ch.length);

                        if (map.containsKey(check)) {
                            res.add(Arrays.asList(i, map.get(check)));
                        }
                    }
                }
                // Base case: "lls"
                // 1. check if the "lls" itself can form palindrome by iterate from 0 to j(inclusive). E.g. "lls" -> "ll"
                // 2. check if the 'remaining length 'of the word is in the dict. E.g. "lls" -> "s" is the remaining length
                // 3. check if the remaining length can be put at the front of the word to form a palindrome
                //    We can do step 3 by :
                // 4. reverse the word and get the remaining length, and
                // 5. check if the reversed subword(check) is in the map
                for (int j = 0; j < ch.length - 1; j++) {

                    if (dict[ch.length - j - 1] && isPalindrome(ch, 0, j)) {

                        String check = re.substring(0, ch.length - j - 1);

                        if (map.containsKey(check)) {
                            res.add(Arrays.asList(map.get(check), i));
                        }
                    }
                }
                // Base case: "llll"
                // if the word itself is a palindrome
                // no need to add other word or 
                // no need check reversed word
                if (isPalindrome(ch, 0, ch.length - 1)) {
                    // check if the map contains empty string
                    if (map.containsKey("")) {
                        int index = map.get("");
                        res.add(Arrays.asList(index, i));
                        res.add(Arrays.asList(i, index));
                    }
                // Base case: "abcd" -> "dcba"
                // if the word is palindrome by reversing itself
                } else if (map.containsKey(re)) {
                    res.add(Arrays.asList(i, map.get(re)));
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(char[] ch, int left, int right) {
        while (left < right) {
            if (ch[left] != ch[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}