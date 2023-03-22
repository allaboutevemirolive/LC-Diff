import java.util.ArrayList;
import java.util.List;

class D301 {
    // maximum length of valid parentheses string
    int mxlen;
    // stores all valid parentheses strings
    List<String> results;

    public List<String> removeInvalidParentheses(String s) {
        int count = 0, unmatch = 0;
        results = new ArrayList<>();

        // count unbalanced parentheses
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            // update unmatch count for closing parentheses without matching opening parentheses
            if (count < 0) {
                count = 0;
                unmatch++;
            }
        }
        // add unbalanced opening parentheses to unmatch count
        unmatch += count; 

        // set maximum length of valid parentheses string
        mxlen = s.length() - unmatch; 

        // perform depth-first search to generate all valid parentheses strings
        dfs(s, 0, "", 0); 
        return results;
    }

    // helper function to perform depth-first search
    private void dfs(String s, int idx, String curr, int count) {
        if (count < 0)
            return;
        if (curr.length() > mxlen)
            return;
        if (idx == s.length()) {
            // check if current string is valid and has maximum length
            if (count == 0 && curr.length() == mxlen) { 
                results.add(curr);
            }
            return;
        }

        // if current character is not a parenthesis, keep it
        if (s.charAt(idx) != '(' && s.charAt(idx) != ')') { 
            dfs(s, idx + 1, curr + s.charAt(idx), count);
        } else {
            // include current parenthesis
            dfs(s, idx + 1, curr + s.charAt(idx), count + (s.charAt(idx) == '(' ? 1 : -1)); 
            // exclude current parenthesis
            if (curr.isEmpty() || s.charAt(idx) != curr.charAt(curr.length() - 1)) { 
                dfs(s, idx + 1, curr, count);
            }
        }
    }
}
