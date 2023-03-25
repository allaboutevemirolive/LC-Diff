public class y321merge {
    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 5 };
        int[] nums2 = { 2, 4, 6 };

        int[] result = merge(nums1, nums2);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    

    private static int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < n && j < m) {
            // if (nums1[i] <= nums2[j]) {  // output : 1 2 3 4 5 6
            if (compare(nums1, i, nums2, j) > 0) { // output : 2 4 6 1 3 5 
                result[index] = nums1[i];
                i++;
            } else {
                result[index] = nums2[j];
                j++;
            }
            index++;
        }

        while (i < n) {
            result[index] = nums1[i];
            i++;
            index++;
        }

        while (j < m) {
            result[index] = nums2[j];
            j++;
            index++;
        }

        return result;
    }

    private static int compare(int[] nums1, int i, int[] nums2, int j) {
        int n = nums1.length;
        int m = nums2.length;

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

        return nums1[i] - nums2[j];
    }
}
