import java.util.ArrayList;
import java.util.List;

class B301 {
    public List<String> removeInvalidParentheses(String s) {
        // List to store valid strings
        List<String> ans = new ArrayList<>();
        // call helper function
        remove(s, ans, 0, 0, new char[] { '(', ')' });
        // return list of valid strings
        return ans;
    }

    // Two times we recusrsively call "remove" method
    // First is to check invalid closing bracket
    // Second is to check invalid opening brackets by reversing valid parenthesis expression. 
    // iPtr and jPtr is set to zero so the traverse is start from the first par
    public void remove(String s, List<String> ans, int iPtr, int jPtr, char[] par) {
        int stack = 0;
        // Determine which char index is the first invalid closing bracket
        for (int i = iPtr; i < s.length(); ++i) {
            // If current char is opening bracket, increment stack
            if (s.charAt(i) == par[0]) {
                stack++;
            }

            // If current char is closing bracket, decrement stack
            if (s.charAt(i) == par[1]) {
                stack--;
            }

            // If stack is not negative, continue to next char
            if (stack >= 0) {
                continue;
            }

            // If stack is negative, string has invalid parentheses.

            // i is the first invalid closing bracket
            // j will will try all possible combination of the input by making j as exclusive in the substring method
            for (int j = jPtr; j <= i; ++j) {
                // If current char is closing bracket and the previous char is not closing bracket,
                // remove current char
                // s.charAt(j) == par[1] is to check if current char is closing bracket
                // j == jPtr is to check if current char is the first invalid closing bracket
                // s.charAt(j - 1) != par[1] is to check if previous char is not closing bracket
                if (s.charAt(j) == par[1] && (j == jPtr || s.charAt(j - 1) != par[1])) {
                    // i is the first invalid closing bracket
                    // i will pass as iPtr and wil use as starting point to traverse the string
                    remove(
                            // s.substring(0, j) is the string from the beginning to the current char(exclusive)
                            s.substring(0, j) +
                            // s.substring(j + 1, s.length()) is the string from the next char to the end
                                    s.substring(j + 1, s.length()),
                            ans,
                            i,
                            j,
                            par);
                }
            }
            // Exit function
            return;
        }
        // There is 2 times reversing happen
        // First to check if a valid par has invalid closing bracket
        // Second reverse , to reverse back to normal and add it to ans
        String reversed = new StringBuilder(s).reverse().toString();
        // "if" is for removing invalid opening brackets
        // traverse reversed string from right to left or traverse from left to right 
        if (par[0] == '(') {
            // Second is to check invalid opening brackets by reversing valid parenthesis expression. 
            // iPtr and jPtr is set to zero so the traverse is start from the first par
            remove(reversed, ans, 0, 0, new char[] { ')', '(' });
        } else {
            // If we reached the end of the string from right to left and par[0] is ')',
            // it means we have a valid string
            ans.add(reversed);
        }
    }
}