import java.util.*;

public class B0022 {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, n, "", result);
        return result;
    }

    private static void generateParenthesis(int open, int close, String str, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(str);
            return;
        }

        if (open > 0) {
            generateParenthesis(open - 1, close, str + "(", result);
        }

        if (close > open) {
            generateParenthesis(open, close - 1, str + ")", result);
        }
    }
}
