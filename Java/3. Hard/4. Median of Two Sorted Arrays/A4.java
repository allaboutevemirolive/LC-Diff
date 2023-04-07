public class A4 {
    public static void main(String[] args) {

        int[] nums1 = { 1, 10, 3, 12 };
        int[] nums2 = { 10, 12, 14, 16, 18, 20 };

        double median = B4.findMedianSortedArrays(nums1, nums2);
        System.out.println("The median of the two sorted arrays is: " + median);
    }
}
