import java.util.ArrayList;
import java.util.List;

class G93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }
    
    // Backtracking method to generate all possible valid IP addresses
    private void backtrack(String inputString, int currentIndex, int currentSegment, StringBuilder currentIp, List<String> result) {
        // If we have reached the end of the input string and we have 4 segments, we have a valid IP address
        if (currentIndex == inputString.length() && currentSegment == 4) {
            result.add(currentIp.toString());
            return;
        }
        
        // If we have reached the end of the input string or we have 4 segments, return as it's not a valid IP address
        if (currentIndex == inputString.length() || currentSegment == 4) return;
        
        int originalLength = currentIp.length();
        for (int i = 1; i <= 3 && currentIndex + i <= inputString.length(); i++) {
            // Generate the current substring with length i
            String currentSubstring = inputString.substring(currentIndex, currentIndex + i);
            
            // Check if the current substring is a valid segment (1 to 3 digits, no leading 0)
            if (currentSubstring.length() > 1 && currentSubstring.charAt(0) == '0') break;
            int currentNum = Integer.parseInt(currentSubstring);
            if (currentNum >= 0 && currentNum <= 255) {
                // Append the current segment to the IP address
                currentIp.append(currentSubstring);
                
                // If this is not the last segment, append a '.'
                if (currentSegment < 3) currentIp.append(".");
                
                // Backtrack with updated index and segment
                backtrack(inputString, currentIndex + i, currentSegment + 1, currentIp, result);
                
                // Reset the length of the IP address back to the original length
                currentIp.setLength(originalLength);
            }
        }
    }
}
