class B3 {
    public int findLength(String s) {
        if (s.length() == 0) return 0;
        int[] charFrequency = new int[95]; // array to store frequency of characters in the current substring
        int maxLength = 0, end = 0, start = 0; // variables to keep track of start and end indices of the current substring
        while (end < s.length()) {
            char currentChar = s.charAt(end++); // get the current character and increment end index
            charFrequency[currentChar - ' ']++; // increment the frequency of current character
            while (charFrequency[currentChar - ' '] > 1) { // if the frequency of current character is more than 1, it means the current character is repeated
                charFrequency[s.charAt(start++) - ' ']--; // decrement the frequency of the character at start index and increment start index
            }
            maxLength = Math.max(maxLength, end - start); // update the length of the longest substring without repeating characters
        }
        return maxLength;
    }
}
