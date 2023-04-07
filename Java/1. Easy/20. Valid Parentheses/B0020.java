import java.util.Stack;

public class B0020 {
    
    public static boolean isValid(String s) {
        // create a stack to store the open parentheses
        Stack<Character> stack = new Stack<>();

        // iterate through the string and check each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                // if the character is an open parenthesis, push it onto the stack
                stack.push(c);
            } else {
                // if the character is a close parenthesis, check if it has a corresponding open parenthesis
                if (stack.isEmpty()) {
                    // if the stack is empty, there is no corresponding open parenthesis
                    return false;
                }
                char open = stack.pop();
                if ((c == ')' && open != '(') || (c == ']' && open != '[') || (c == '}' && open != '{')) {
                    // if the close parenthesis does not match the corresponding open parenthesis, the string is invalid
                    return false;
                }
            }
        }

        // if the stack is not empty, there are unclosed open parentheses
        return stack.isEmpty();
    }
}
