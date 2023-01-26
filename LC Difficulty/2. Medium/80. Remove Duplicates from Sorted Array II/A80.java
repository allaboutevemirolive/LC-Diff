public class A80 {
    public static void main(String[] args) {
        B80 obj = new B80();
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int result = obj.removeDuplicates(nums);
        System.out.println("Number of unique elements: " + result);
    }
}
