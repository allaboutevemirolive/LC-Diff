class B5 {
    public String longestPalindrome(String s) {
        // Get the length of the input string
        int length = s.length();
        
        // Initialize the variables to store the length and the start and end index of the longest palindromic substring
        int maxLength = 0;
        int startIndex = 0;
        int endIndex = 0;
        
        // Loop through each character in the string
        for (int currentIndex = 0; currentIndex < length;) {
            // Set the left and right index to the current index
            int leftIndex = currentIndex;
            int rightIndex = currentIndex;
            
            // Expand the right index to cover continuous same characters
            while (rightIndex < length - 1 && s.charAt(rightIndex) == s.charAt(rightIndex + 1)) rightIndex++;
            
            // Update the current index for next iteration
            currentIndex = rightIndex + 1;
            
            // Expand the left and right index until it forms a palindromic substring
            while (leftIndex > 0 && rightIndex < length - 1 && s.charAt(leftIndex - 1) == s.charAt(rightIndex + 1)) {
                leftIndex--;
                rightIndex++;
            }
            
            // Calculate the current length of the palindromic substring
            int currentLength = rightIndex - leftIndex + 1;
            
            // Update the max length and the start and end index if the current length is longer
            if (currentLength > maxLength) {
                maxLength = currentLength;
                startIndex = leftIndex;
                endIndex = rightIndex + 1;
            }
        }
        return s.substring(startIndex, endIndex);
    }
}
