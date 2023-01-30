import java.util.ArrayList;
import java.util.List;

public class B93 {
    // Recursive function to restore IP addresses
    public void restoreIpAddresses(List<String> result, char[] buffer, int x, String s, int index, int number) {
        // If the number of integers (separated by dots) is 4, check if all characters in the string are processed
        if (number == 4) {
            if (index == s.length()) {
                // If yes, add the buffer containing IP address to result
                result.add(new String(buffer));
            }
            // Return to prevent further processing
            return;
        }
        int mem = 0;
        // Loop through up to 3 characters from the index in the string
        for (int i = 0; i < 3 && index + i < s.length(); i++) {
            mem = mem * 10 + s.charAt(index + i) - '0';
            // If the integer value is larger than 255, break the loop
            if (mem > 255) break;
            // Copy the processed character to the buffer
            buffer[x + i] = s.charAt(index + i);
            // If there's room for the dot in the buffer, add it
            if (x + i + 1 < buffer.length) {
                buffer[x + i + 1] = '.';
            }
            // Recursively call the function to process the next integer
            restoreIpAddresses(result, buffer, x + i + 2, s, index + i + 1, number + 1);
            // If the integer value is 0, break the loop to prevent leading 0s
            if (mem == 0) break;
        }
    }

    // Wrapper function to return the result
    public List<String> restoreIpAddresses(String s) {
        // Create a list to store the result
        ArrayList<String> result = new ArrayList<>();
        // Call the recursive function to process the string
        restoreIpAddresses(result, new char[s.length() + 3], 0, s, 0, 0);
        // Return the result
        return result;
    }
}
