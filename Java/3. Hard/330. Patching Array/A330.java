public class A330 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 5, 10, 20, 50, 100, 200 };
        int n = 1000;

        C330 obj = new C330();
        int result = obj.minPatches(nums, n);

        System.out.println("Minimum number of patches required: " + result);
    }
}
