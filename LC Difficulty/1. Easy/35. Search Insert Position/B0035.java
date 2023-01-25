public class B0035 {
    
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // if the target is found, return the index
            if (nums[mid] == target) return mid;
            // if the target is smaller than the element at the midpoint, search the left half of the array
            else if (target < nums[mid]) right = mid - 1;
            // if the target is larger than the element at the midpoint, search the right half of the array
            else left = mid + 1;
        }
        // if the target is not found, it should be inserted at the index where the search stopped
        return left;
    }
}
