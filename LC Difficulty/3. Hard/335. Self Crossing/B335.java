class B335 {
    public boolean isSelfCrossing(int[] x) {
        // If the length of the array is less than or equal to 3, 
        // then return false because there cannot be any self-crossing in this case.
        if (x.length <= 3) {  
            return false;
        }
        // Initialize i to 2 because the first two elements of the array are already used in the initial movement.
        int i = 2;
        // Check if the path is expanding or not by comparing the current element with two elements before it. 
        // If the path is still expanding, then move forward.
        while (i < x.length && x[i] > x[i - 2]) {  
            i++;
        }
        // If i has reached the end of the array, then return false because there cannot be any self-crossing in this case.
        if (i >= x.length) {  
            return false;
        }
        // Check if the path is intersecting with itself. If it is, then modify the path to avoid self-crossing.
        if ((i >= 4 && x[i] >= x[i - 2] - x[i - 4]) || (i == 3 && x[i] == x[i - 2])) {  
            x[i - 1] -= x[i - 3];
        }
        // Move forward one step.
        i++;  
        // Check if the modified path intersects with itself.
        while (i < x.length) {  
            if (x[i] >= x[i - 2]) {
                // If the path intersects with itself, then return true.
                return true;  
            }
            i++;
        }
        // If there is no self-crossing, then return false.
        return false;  
    }
}
