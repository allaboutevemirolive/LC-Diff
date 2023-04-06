
public class A0009 {

	public static void main(String[] args) {
        int x = 121;
        boolean isPalindrome = B0009.isPalindrome(x);
        System.out.println("Is " + x + " a palindrome? " + isPalindrome);
    
        x = -121;
        isPalindrome = B0009.isPalindrome(x);
        System.out.println("Is " + x + " a palindrome? " + isPalindrome);
    
        x = 10;
        isPalindrome = B0009.isPalindrome(x);
        System.out.println("Is " + x + " a palindrome? " + isPalindrome);
    }
    

}
