import java.util.ArrayList;
import java.util.List;

// Iterative approach
public class C89 {
    // Function to generate and return the gray code sequence
    public List<Integer> grayCode(int n) {
        // Initialize an empty list to store the result
        List<Integer> result = new ArrayList<>();
        // Add the first integer, which is 0, to the result
        result.add(0);
        
        // Iterate for the number of bits specified by the input 'n'
        for (int i = 0; i < n; i++) {
            // Store the size of the 'result' list in a variable for efficient looping
            int size = result.size();
            // Iterate through the 'result' list in reverse order
            for (int j = size - 1; j >= 0; j--) {
                // Add the element from the 'result' list with a bit shifted to the left by the current iteration number
                // This is done using the bitwise OR operator
                result.add(result.get(j) | 1 << i);
            }
        }
        // Return the final result
        return result;
    }
}
