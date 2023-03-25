class y321compare {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3}; // output : -1
        int[] nums2 = {1, 2, 4};

        int result = compare(nums1, 2, nums2, 2);

        System.out.println(result);
    }

    private static int compare(int[] nums1, int i, int[] nums2, int j) {
        int n = nums1.length;
        int m = nums2.length;

        // i pointer is less than length of nums1
        // j pointer is less than length of nums2
        // current value of nums1 is equal to current value of nums2
        while (i < n && j < m && nums1[i] == nums2[j]) {
            i++;
            j++;
        }

        if (i == n) {
            return -1;
        }

        if (j == m) {
            return 1;
        }

        // execute when the array is not equal
        return nums1[i] - nums2[j];
    }
}
