class B904 {
    public int totalFruit(int[] fruits) {
        // If the length of the input array is 1, return 1
        if (fruits.length == 1) {
            return 1;
        }

        // Initialize two pointers and the result
        int leftPointer = 0;
        int result = 0;
        int[] currentFruits = new int[]{fruits[0], -1};
        
        // Iterate through the input array from the second element
        for (int rightPointer = 1; rightPointer < fruits.length; ++rightPointer) {
            int fruit = fruits[rightPointer];
            
            // Check if the current fruit is different from both of the current fruits
            if (fruit != currentFruits[0] && fruit != currentFruits[1]) {
                // If the second current fruit is not set, set it to the current fruit
                if (currentFruits[1] == -1) {
                    currentFruits[1] = fruit;
                    continue;
                }
                // Update the result
                result = Math.max(result, rightPointer - leftPointer);
                
                // Move the left pointer back to find the new starting position
                int previousFruit = fruits[rightPointer - 1];
                leftPointer = rightPointer - 1;
                while (fruits[leftPointer - 1] == previousFruit) {
                    leftPointer--;
                }
                // Update the current fruits
                currentFruits[0] = previousFruit;
                currentFruits[1] = fruit;
            }
        }
        // Return the final result
        return Math.max(fruits.length - leftPointer, result);
    }
}
