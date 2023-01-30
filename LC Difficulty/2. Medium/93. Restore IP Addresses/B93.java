import java.util.ArrayList;
import java.util.List;

public class B93 {
    // Wrapper function to return the result
    public List<String> restoreIpAddresses(String s) {
        // Create a list to store the result
        ArrayList<String> result = new ArrayList<>();
        // Call the recursive function to process the string
        restoreIpAddresses(result, new char[s.length() + 3], 0, s, 0, 0);
        // Return the result
        return result;
    }
    /*
     * Recursive function to restore IP addresses
     * 
     * result: This is a list of Strings that will store the final output.
     * 
     * buffer: This is a character array that is used to store the intermediate IP address 
     * during the calculation process.
     * 
     * x: This is the starting position in the buffer array where the current IP address segment is stored.
     * 
     * s: This is the input string that contains the IP address.
     * 
     * index: This is the starting position in the input string where the current IP address segment starts.
     * 
     * number: This is the current segment of the IP address being processed. 
     * It ranges from 1 to 4, representing the 4 segments of an IP address.
     */
    public void restoreIpAddresses(List<String> result, char[] buffer, int x, String s, int index, int number) {
        // Checks if the length of the current extracted IP address segment is 4 characters long
        if (number == 4) {
            //  Check if the entire input string s has been processed 
            if (index == s.length()) {
                // If yes, add the buffer containing IP address to result
                result.add(new String(buffer));
            }
            // Return to prevent further processing
            return;
        }
        int mem = 0;
        /*
         * Loop through 3 characters of the string 's', 
         * starting from the current position given by 'index'.
         * 
         * the loop continues as long as 'i' is less than 3
         * 
         * The loop continues only if there are still i characters remaining in the string 
         * after the current position 'index'
         * 
         * This limits the loop to only get at most 3 characters from the string 's' at each iteration
         */
        for (int i = 0; i < 3 && index + i < s.length(); i++) {
            // Convert a sequence of digits in the input string s into an integer value
            mem = mem * 10 + s.charAt(index + i) - '0';
            // Condition 1
            // If the integer value is larger than 255, break the loop
            if (mem > 255) break;
            // Copies the current character from the input string s 
            // to the buffer array at the position x + i
            buffer[x + i] = s.charAt(index + i);
            // Check whether there is enough space in the buffer array 
            // to store the next character
            // The purpose of the expression x + i + 1 is to determine the next index in the buffer array 
            // after the current character (which is stored at x + i) has been added
            if (x + i + 1 < buffer.length) {
                // If there is enough room in the buffer array (i.e. x + i + 1 < buffer.length), 
                // then a dot '.' is added after the character at the index x + i + 1
                buffer[x + i + 1] = '.';
            }
            // Recursively call the function to process the next integer
            restoreIpAddresses(result, buffer, x + i + 2, s, index + i + 1, number + 1);
            // Condition 2
            // Checks if the computed integer value mem has leading zeros, 
            // and if so, it stops the loop
            if (mem == 0) break;
        }
    }

}
