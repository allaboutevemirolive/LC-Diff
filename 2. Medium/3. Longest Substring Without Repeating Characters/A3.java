
public class A3 {
    public static void main(String[] args) {
        C3 obj = new C3();
        String s = "geeksforgeeks";
        int longestSubstringLength = obj.lengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring without repeating characters in the string " + s + " is: " + longestSubstringLength);
    }
}
