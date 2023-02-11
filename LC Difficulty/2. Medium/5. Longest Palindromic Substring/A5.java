class A5 {
    public static void main(String[] args) {
        B5 obj = new B5();
        String s = "babad";
        String longestPalindrome = obj.longestPalindrome(s);
        System.out.println("The longest palindrome in the string " + s + " is: " + longestPalindrome);
    }
}
