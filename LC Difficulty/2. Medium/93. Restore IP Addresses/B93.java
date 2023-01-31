import java.util.ArrayList;
import java.util.List;

public class B93 {

    // Method to return a list of all valid IP addresses that can be obtained from the input string
    public List<String> restoreIpAddresses(String input) {
        // Initialize list to store valid IP addresses
        List<String> validAddresses = new ArrayList<>();
        // Initialize character array to store each valid IP address as it's being constructed
        char[] addressBuffer = new char[input.length() + 3];
        // Call helper method to construct and add valid IP addresses to the list
        restoreAddresses(validAddresses, addressBuffer, 0, input, 0, 0);
        return validAddresses;
    }

    // Helper method to construct and add valid IP addresses to the list
    private void restoreAddresses(List<String> validAddresses, char[] addressBuffer, int bufferIndex, String input, int inputIndex, int segmentsCount) {
        // If 4 segments have been constructed, check if all characters of the input string have been processed
        if (segmentsCount == 4) {
            // If all characters have been processed, add the constructed IP address to the list
            if (inputIndex == input.length()) {
                validAddresses.add(new String(addressBuffer));
            }
            // Return if 4 segments have been constructed but not all characters have been processed
            return;
        }

        // Initialize current segment
        int currentSegment = 0;
        // Loop through up to 3 characters of the input string
        for (int i = 0; i < 3 && inputIndex + i < input.length(); i++) {
            // Construct current segment by converting characters to integer and adding to current segment
            currentSegment = currentSegment * 10 + input.charAt(inputIndex + i) - '0';
            // If current segment is greater than 255, break the loop
            if (currentSegment > 255) break;
            // Add current character to the address buffer
            addressBuffer[bufferIndex + i] = input.charAt(inputIndex + i);
            // If there is room in the buffer, add a period to separate segments
            if (bufferIndex + i + 1 < addressBuffer.length) {
                addressBuffer[bufferIndex + i + 1] = '.';
            }
            // Recursively call the helper method with updated parameters to construct the next segment
            restoreAddresses(validAddresses, addressBuffer, bufferIndex + i + 2, input, inputIndex + i + 1, segmentsCount + 1);
            // If current segment is 0, break the loop
            if (currentSegment == 0) break;
        }
    }
}
