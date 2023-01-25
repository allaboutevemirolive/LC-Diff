public class B0008 {
    
    public static int myAtoi(String str) {
        int n = str.length();
        int i = 0;
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        boolean isNegative = str.charAt(i) == '-';
        if (isNegative || str.charAt(i) == '+') {
            i++;
        }
        int result = 0;
        int maxLimit = Integer.MAX_VALUE / 10;
        for (; i < n; i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                break;
            }
            int digit = ch - '0';
            if (result > maxLimit || (result == maxLimit && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = (result * 10) + digit;
        }
        return isNegative ? -result : result;
    }
}
