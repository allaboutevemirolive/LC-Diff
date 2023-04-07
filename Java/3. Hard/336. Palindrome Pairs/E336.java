import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class E336 {
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
            System.out.println();
            System.out.println("==================================");
            String word = words[i];
            System.out.println("word: " + word);
            System.out.println("i: " + i);
            if (word.length() > 0) {
                char[] ch = word.toCharArray();
                System.out.println("ch: " + Arrays.toString(ch));

                String re = new StringBuilder(word).reverse().toString();
                System.out.println("re: " + re);

                for (int j = 0; j < ch.length - 1; j++) {
                    System.out.println();

                    System.out.println("i: " + i + ", j: " + j);

                    System.out.print("ch(j + 1, ch.length - 1(inclusive)): " );
                    for (int k = j + 1 ; k <= ch.length - 1; k++) {
                        System.out.print(ch[k]);
                    }

                    System.out.println();

                    boolean isTrue = isPalindrome(ch, j + 1, ch.length - 1);
                    System.out.println("isTrue: " + isTrue);
                    System.out.println("dict[j + 1]: " + dict[j + 1]);

                    if (dict[j + 1] && isTrue) {
                        System.out.println("is palindrome");

                        String check = re.substring(ch.length - j - 1, ch.length);
                        System.out.println("re: " + re + "\nch.length - j - 1: " + (ch.length - j - 1));
                        System.out.println("check: " + check);

                        if (map.containsKey(check)) {

                            System.out.println("map.containsKey(check)");
                            System.out.println("res(before): " + res);
                            res.add(Arrays.asList(i, map.get(check)));
                            System.out.println("res(after) : " + res);
                        } else {
                            System.out.println("not map.containsKey(check)");
                        }
                    } else {
                        System.out.println("not palindrome");
                    }
                }

                for (int j = 0; j < ch.length - 1; j++) {

                    if (dict[ch.length - j - 1] && isPalindrome(ch, 0, j)) {
                        String check = re.substring(0, ch.length - j - 1);

                        if (map.containsKey(check)) {
                            res.add(Arrays.asList(map.get(check), i));
                        }
                    }
                }
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
        while (left < right) {
            if (ch[left] != ch[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}