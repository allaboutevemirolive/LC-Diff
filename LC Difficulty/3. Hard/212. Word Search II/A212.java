import java.util.List;

public class A212 {
    public static void main(String[] args) {
        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        String[] words = { "oath", "pea", "eat", "rain" };
        B212 obj = new B212();
        List<String> answer = obj.findWords(board, words);
        System.out.println(answer);
    }

}
