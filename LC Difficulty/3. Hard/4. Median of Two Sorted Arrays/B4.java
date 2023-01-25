public class B4 {
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // if the length of nums1 is greater than nums2, swap the arrays
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m;

        // binary search on nums1
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            // left partition of x
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            // right partition of x
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            // left partition of y
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            // right partition of y
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // we have found the correct partition
                if ((m + n) % 2 == 0) {
                    // if the length of the combined array is even, the median is the average of the two middle elements
                    return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    // if the length of the combined array is odd, the median is the middle element
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // we need to move to the left of partitionX
                high = partitionX - 1;
            } else {
                // we need to move to the right of partitionX
                low = partitionX + 1;
            }
        }

        // if we reach here, it means that the input arrays are not sorted
        throw new IllegalArgumentException();
    }
}
