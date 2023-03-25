public class A321 {
    public static void main(String[] args) {
        C321 obj = new C321();
        int[] nums1 = { 3, 4, 6, 5 };
        int[] nums2 = { 9, 1, 2, 5, 8, 3 };
        int k = 5;
        int[] result = obj.maxNumber(nums1, nums2, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
