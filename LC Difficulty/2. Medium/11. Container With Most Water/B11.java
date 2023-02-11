class B11 {
    public int maxArea(int[] heights) {
        // Initialize two pointers, leftPointer and rightPointer, to traverse the heights array
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        // Initialize maxWater to keep track of the maximum amount of water the container can store
        int maxWater = Integer.MIN_VALUE;

        // Keep moving the pointers until they cross each other
        while (leftPointer < rightPointer) {
            // Get the height of the line at the leftPointer and rightPointer
            int leftHeight = heights[leftPointer];
            int rightHeight = heights[rightPointer];
            // Get the minimum height of the two lines
            int minHeight = Math.min(leftHeight, rightHeight);
            // Calculate the area of the container formed by the two lines and update maxWater if necessary
            maxWater = Math.max(maxWater, minHeight * (rightPointer - leftPointer));
            // If the line at the leftPointer is taller than the line at the rightPointer, move the rightPointer towards the left
            // This is because the width of the container is reduced, so we need a taller line to compensate for the lost area
            if (leftHeight > rightHeight) {
                while (heights[rightPointer] <= rightHeight && leftPointer < rightPointer) {
                    rightPointer--;
                }
            // If the line at the rightPointer is taller than the line at the leftPointer, move the leftPointer towards the right
            // This is because the width of the container is reduced, so we need a taller line to compensate for the lost area
            } else {
                while (heights[leftPointer] <= leftHeight && leftPointer < rightPointer) {
                    leftPointer++;
                }
            }
        }
        // Return the maximum amount of water the container can store
        return maxWater;
    }
}
