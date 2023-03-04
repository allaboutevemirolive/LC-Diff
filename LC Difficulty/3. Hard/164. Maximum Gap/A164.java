public class A164 {
    public static void main(String[] args) {
        int[] nums = { 3, 6, 9, 1 };
        B164 obj = new B164();
        int result = obj.maximumGap(nums);
        System.out.println("The maximum gap is: " + result);
    }
}
