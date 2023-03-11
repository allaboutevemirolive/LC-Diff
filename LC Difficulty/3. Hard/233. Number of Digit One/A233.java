public class A233 {
    public static void main(String[] args) {
        int n = 13;
        B233 obj = new B233();
        int count = obj.countDigitOne(n);
        System.out.println("The total number of digit 1s from 0 to " + n + " is " + count);
    }
}
