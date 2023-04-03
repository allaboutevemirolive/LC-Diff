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
            System.out.println("=====================================");
            String word = words[i];
            System.out.println("i: " + i + "\nword: " + word + "\nmap: " + map);

            if (word.length() > 0) {
                System.out.println();
                char[] ch = word.toCharArray();

                String re = new StringBuilder(word).reverse().toString();

                System.out.println("ch: " + Arrays.toString(ch) + "\nre: " + re);

                System.out.println();
                System.out.println("-------------------------------------");
                System.out.println("for 1");
                for (int j = 0; j < ch.length - 1; j++) {

                    // isPalindrome(char[] ch, int left, int right)
                    System.out.println("ch: " + Arrays.toString(ch) + "\nleft: " + (j + 1) + "\nright: " + (ch.length - 1));
                    boolean isTrue = isPalindrome(ch, j + 1, ch.length - 1);

                    if (dict[j + 1] && isTrue) {
                        System.out.println();
                        System.out.println("TRUE");
                        System.out.println("re: " + re + "\nbeginIndex(ch.length - j - 1): " + (ch.length - j - 1) + "\nendIndex(ch.length): " + ch.length);
                        String check = re.substring(ch.length - j - 1, ch.length);
                        System.out.println("check: " + check);

                        if (map.containsKey(check)) {
                            System.out.println("map.containsKey(check): " + map.containsKey(check));
                            res.add(Arrays.asList(i, map.get(check)));
                        } else {
                            System.out.println("map.containsKey(check): " + map.containsKey(check));
                        }
                    } else {
                        System.out.println();
                        System.out.println("FALSE");
                    }
                }
                System.out.println();
                System.out.println("-------------------------------------");
                System.out.println("for 2");
                for (int j = 0; j < ch.length - 1; j++) {

                    if (dict[ch.length - j - 1] && isPalindrome(ch, 0, j)) {
                        String check = re.substring(0, ch.length - j - 1);

                        if (map.containsKey(check)) {
                            res.add(Arrays.asList(map.get(check), i));
                        }
                    }
                }

                System.out.println("-------------------------------------");
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