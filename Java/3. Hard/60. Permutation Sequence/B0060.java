import java.util.LinkedList;
import java.util.List;

public class B0060 {
    public String getPermutation(int n, int k) {
        // Create a list of numbers from 1 to n
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        // Initialize factorial value to 1
        int factorial = 1;
        // Calculate factorial of n
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        StringBuilder sb = new StringBuilder();
        k--;
        // Iterate through the list of numbers in reverse order
        for (int i = n; i > 0; i--) {
            // Divide factorial by i
            factorial /= i;
            // Get the index of the next number to append by dividing k by the factorial
            int idx = k / factorial;
            k %= factorial;
            // Append the number at the index to the result string
            sb.append(nums.get(idx));
            // Remove the used number from the list
            nums.remove(idx);
        }
        return sb.toString();
    }
}