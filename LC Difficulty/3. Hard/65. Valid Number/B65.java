class B65 {
    public boolean isNumber(String s) {
        // check if the string is empty and return false if it is
        if (s.isEmpty()) return false;
        // remove leading and trailing whitespaces
        s = s.trim();
        boolean hasNum = false, hasDot = false, hasE = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // check if the current character is a digit
            if (c >= '0' && c <= '9') {
                hasNum = true;
            } 
            // check if the current character is a dot
            else if (c == '.') {
                // return false if there is already a dot or e/E
                if (hasDot || hasE) return false;
                hasDot = true;
            } 
            // check if the current character is e/E
            else if (c == 'e' || c == 'E') {
                // return false if there is no number before e/E or if there is already an e/E
                if (!hasNum || hasE) return false;
                hasE = true;
                hasNum = false;
            } 
            // check if the current character is a + or -
            else if (c == '+' || c == '-') {
                // return false if the + or - is not immediately after e/E
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } 
            // return false if the current character is not a digit, dot, e/E, +, or -
            else {
                return false;
            }
        }
        // return true if there is a number
        return hasNum;
    }
}
