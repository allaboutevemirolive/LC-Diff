public class A154 {
    public static void main(String[] args) {
        B154 obj = new B154();
        int[] nums1 = {0,1,4,4,5,6,7};
        int[] nums2 = {2, 2, 2, 0, 1};
        int min1 = obj.findMin(nums1);
        int min2 = obj.findMin(nums2);
        System.out.println("Minimum element of nums1: " + min1);
        System.out.println("Minimum element of nums2: " + min2);
    }
    
}
