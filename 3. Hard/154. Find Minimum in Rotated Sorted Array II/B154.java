class B154 {
    public int findMin(int[] nums) {
        // Initialize left and right pointers to the first and last indices of the array
        int left = 0;
        int right = nums.length - 1; 
        // Perform binary search until left is less than right
        while (left < right) { 
            // Calculate the middle index
            int mid = (left + right) / 2; 
            // If the middle element is greater than the right element
            if (nums[mid] > nums[right]) { 
                // Update left to mid + 1, since the minimum element must be in the range mid+1 to right
                left = mid + 1; 
            // If the middle element is less than the right element
            } else if (nums[mid] < nums[right]) { 
                // Update right to mid, since the minimum element must be in the range left to mid
                right = mid; 
            // If the middle element is equal to the right element
            } else { 
                // Decrement right by 1, since we can't determine which side of the array the minimum element is on
                right--; 
            }
        }
        // Return the element at the left index, which should be the minimum element
        return nums[left]; 
    }
}
