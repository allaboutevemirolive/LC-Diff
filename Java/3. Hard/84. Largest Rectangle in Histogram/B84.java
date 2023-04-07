class B84 {
    // This method finds the largest rectangle area in a histogram
    public int largestRectangleArea(int[] heights) {
        // Initialize maxArea to 0, top of stack to 0, and topValue to 0
        int maxArea = 0, top = 0, topValue;
        // Create two stacks, one for storing heights, and one for storing indices
        int[] stack = new int[heights.length + 1];
        int[] index = new int[heights.length + 1];

        // Iterate through the heights array
        for (int i = 0; i < heights.length; i++) {
            // While the current height is less than the height at the top of the stack
            while (heights[i] < stack[top]) {
                // Set topValue to the value at the top of the stack
                topValue = stack[top];
                // Decrement top while the value at the new top is equal to topValue
                while (stack[--top] == topValue) {
                }
                // Update maxArea with the maximum of maxArea and the product of topValue and
                // the difference between the current index and the index at the new top of the
                // stack
                maxArea = Math.max(maxArea, topValue * (i - index[top]));
            }
            // Push the current height onto the stack and its index onto the index stack
            stack[++top] = heights[i];
            index[top] = i + 1;
        }
        // While the value at the top of the stack is greater than 0
        while (stack[top] > 0) {
            // Set topValue to the value at the top of the stack
            topValue = stack[top];
            // Decrement top while the value at the new top is greater than or equal to
            // topValue
            while (stack[--top] >= topValue) {
            }
            // Update maxArea with the maximum of maxArea and the product of topValue and
            // the difference between the length of the heights array and the index at the
            // new top of the stack
            maxArea = Math.max(maxArea, topValue * (heights.length - index[top]));
        }
        // Return maxArea
        return maxArea;
    }
}