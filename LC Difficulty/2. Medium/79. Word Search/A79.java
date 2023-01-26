public class A79 {
    public static void main(String[] args) {
        B79 b79 = new B79();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean result = b79.exist(board, word);
        System.out.println(result);
    }
}
