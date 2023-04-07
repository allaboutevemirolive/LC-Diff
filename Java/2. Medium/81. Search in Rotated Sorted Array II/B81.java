class B81 {
    public boolean search(int[] nums, int target) {
        // Initialize left and right pointers for binary search
        int left = 0, right = nums.length - 1;
        
        // Iterate through the array while left pointer is less than or equal to the right pointer
        while (left <= right) {
            // Get the middle index
            int mid = (left + right) / 2;
            
            // Check if the middle element is the target
            if (nums[mid] == target) {
                return true;
            }
            
            // Check if left and middle elements are equal
            if (nums[left] == nums[mid]) {
                // If they are, increment the left pointer and continue
                left++;
                continue;
            }
            
            // Check if the left element is less than or equal to the middle element
            if (nums[left] <= nums[mid]) {
                // Check if the target is between the left and middle elements
                if (nums[left] <= target && target < nums[mid]) {
                    // If it is, set right pointer to mid-1
                    right = mid - 1;
                } else {
                    // Otherwise, set left pointer to mid+1
                    left = mid + 1;
                }
            } else {
                // If the left element is greater than the middle element
                // Check if the target is between the middle and right elements
                if (nums[mid] < target && target <= nums[right]) {
                    // If it is, set left pointer to mid+1
                    left = mid + 1;
                } else {
                    // Otherwise, set right pointer to mid-1
                    right = mid - 1;
                }
            }
        }
        // If target is not found, return false
        return false;
    }
}
