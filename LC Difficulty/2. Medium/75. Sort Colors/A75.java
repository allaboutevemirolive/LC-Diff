public class A75 {
    public static void main(String[] args) {
        B75 b75 = new B75();
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        b75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
