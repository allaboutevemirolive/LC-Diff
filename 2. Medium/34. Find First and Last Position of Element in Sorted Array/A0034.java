import java.util.Arrays;

public class A0034 {

    public static void main(String[] args) {

        int[] nums1 = { 5, 7, 7, 8, 8, 10 };
        int nums2 = 8;
        int[] ansr = B0034.searchRange(nums1, nums2);

        System.out.println(Arrays.toString(ansr));
    }
}
