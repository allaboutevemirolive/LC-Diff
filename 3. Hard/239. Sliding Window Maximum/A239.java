import java.util.Arrays;

public class A239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        B239 solution = new B239();
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result)); // prints [3, 3, 5, 5, 6, 7]
    }
}
