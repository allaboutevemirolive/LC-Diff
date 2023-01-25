public class A0076 {
    public static void main(String[] args) {
        B0076 b0076 = new B0076();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minWindow = b0076.minWindow(s, t);
        System.out.println("The smallest window that contains all characters in t is: " + minWindow);
    }
    
}
