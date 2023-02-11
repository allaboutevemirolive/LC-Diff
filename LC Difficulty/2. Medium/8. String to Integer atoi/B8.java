class B8 {
    
    public int myAtoi(String str) {
        // Initialize `index` to zero and `n` to the length of the string
        int n = str.length();
        int index = 0;
        
        // Ignore leading whitespaces by incrementing the `index` until a non-whitespace character is found or the end of the string is reached
        while (index < n && str.charAt(index) == ' ') {
            index++;
        }
        // Return 0 if all characters are whitespaces
        if (index == n) {
            return 0;
        }
        
        // Check if the first non-whitespace character is '-' or '+'
        boolean isNegative = str.charAt(index) == '-';
        if (isNegative || str.charAt(index) == '+') {
            // Increment the `index` if the character is '-' or '+'
            index++;
        }
        
        // Initialize `result` to zero
        int result = 0;
        int maxLimit = Integer.MAX_VALUE / 10;
        
        // Read in the digits until a non-digit character is found or the end of the string is reached
        for (; index < n; index++) {
            char ch = str.charAt(index);
            // Break the loop if a non-digit character is found
            if (!Character.isDigit(ch)) {
                break;
            }
            int digit = ch - '0';
            // Check if the `result` is greater than `maxLimit` or equal to `maxLimit` and `digit` is greater than 7.
            // In this case, the result will be greater than `Integer.MAX_VALUE`
            if (result > maxLimit || (result == maxLimit && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = (result * 10) + digit;
        }
        // Return the `result` with the appropriate sign
        return isNegative ? -result : result;
    }
}
