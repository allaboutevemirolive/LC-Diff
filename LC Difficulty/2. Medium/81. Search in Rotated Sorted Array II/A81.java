public class A81 {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 1;
        B81 b81 = new B81();
        System.out.println(b81.search(nums, target));
    }
}
