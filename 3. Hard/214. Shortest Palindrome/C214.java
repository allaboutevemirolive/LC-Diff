class C214 {
    public String shortestPalindrome(String s) {
        StringBuilder result = new StringBuilder();
        int palindromeEndIndex = s.length();
        while (true) {
            int j = 0;
            for (int i = palindromeEndIndex - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                }
            }
            if (j == palindromeEndIndex) {
                break;
            }
            palindromeEndIndex = j;
        }
        String suffix = s.substring(palindromeEndIndex);
        String prefix = new StringBuilder(suffix).reverse().toString();
        result.append(prefix).append(s);
        return result.toString();
    }
}