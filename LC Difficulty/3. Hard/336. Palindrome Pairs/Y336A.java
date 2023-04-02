import java.util.*;

public class Y336A {
    
    public static void main(String[] args) {
        String[] words = {"level", "radar", "deified", "civic", "pop", "noon", "racecar", "madam", "kayak"};
        boolean[] dict = {false, true, true, true, true, true, true, true, true, true};
        Map<String, Integer> map = new HashMap<>();
        map.put("level", 0);
        map.put("radar", 1);
        map.put("deified", 2);
        map.put("civic", 3);
        map.put("pop", 4);
        map.put("noon", 5);
        map.put("racecar", 6);
        map.put("madam", 7);
        map.put("kayak", 8);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] ch = word.toCharArray();
            String re = new StringBuilder(word).reverse().toString();
            for (int j = 0; j < ch.length - 1; j++) {
                if (dict[j + 1] && isPalindrome(ch, j + 1, ch.length - 1)) {
                    String check = re.substring(ch.length - j - 1, ch.length);
                    if (map.containsKey(check)) {
                        res.add(Arrays.asList(i, map.get(check)));
                    }
                }
            }
        }
        System.out.println(res);
    }
    
    private static boolean isPalindrome(char[] ch, int left, int right) {
        while (left < right) {
            if (ch[left] != ch[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
