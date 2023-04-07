class B214 {
    public String shortestPalindrome(String s) {
        StringBuilder result = new StringBuilder();
        int start = 0; // initialize the starting index
        int end = s.length(); // initialize the ending index

        // Loop until the longest palindrome starting from the beginning is found
        while (true) {
            // reset the starting index to 0 for each iteration
            start = 0; 
            // Find the longest palindrome starting from the beginning
            for (int i = end - 1; i >= 0; i--) {
                // If the characters match, move to the next index
                if (s.charAt(i) == s.charAt(start)) { 
                    start++;
                }
            }
            // If the starting index equals the ending index, the longest palindrome starting from the beginning is found
            if (start == end) {
                break;
            } else {
                 // Set the new ending index to the starting index for the next iteration
                end = start;
            }
        }

        // Construct the shortest palindrome by appending the substring of s starting from end to the result,
        // reversing it, and then appending s to the end
        result.append(s.substring(end)).reverse().append(s);
        // Convert the StringBuilder to a String and return
        return result.toString(); 
    }
}
