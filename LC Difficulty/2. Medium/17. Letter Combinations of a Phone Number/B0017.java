import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class B0017 {
    static String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Deque<StringBuilder> deque = new ArrayDeque<>();
        deque.offer(new StringBuilder());
        while (!deque.isEmpty()) {
            StringBuilder curr = deque.poll();
            if (curr.length() == digits.length()) {
                res.add(curr.toString());
            } else {
                String letters = map[digits.charAt(curr.length()) - '0'];
                for (char c : letters.toCharArray()) {
                    deque.offer(new StringBuilder(curr).append(c));
                }
            }
        }
        return res;
    }
}
