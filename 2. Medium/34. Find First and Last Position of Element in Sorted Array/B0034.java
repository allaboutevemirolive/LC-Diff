public class B0034 {

    public static int[] searchRange(int[] nums, int target) {
        // Initialize the result to the default range of -1
        int[] result = { -1, -1 };

        // Binary search for the leftmost occurrence of the target
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        // Check if the target was found
        if (nums[start] != target) {
            return result;
        }
        result[0] = start;

        // Binary search for the rightmost occurrence of the target
        end = nums.length - 1;
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        result[1] = end;

        return result;
    }

}
