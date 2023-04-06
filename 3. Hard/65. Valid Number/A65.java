public class A65 {
    public static void main(String[] args) {
        B65 b65 = new B65();
        String s1 = "3.14";
        String s2 = "3e-2";
        String s3 = "abc";
        String s4 = "";
        String s5 = "3.14e2";
    
        System.out.println(b65.isNumber(s1)); // prints true
        System.out.println(b65.isNumber(s2)); // prints true
        System.out.println(b65.isNumber(s3)); // prints false
        System.out.println(b65.isNumber(s4)); // prints false
        System.out.println(b65.isNumber(s5)); // prints true
    }
    
}
