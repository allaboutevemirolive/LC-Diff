// Define a class called B115
class B115 {
    // Define a public method called numDistinct that takes two string arguments s and t
    public int numDistinct(String s, String t) {
        // Convert the target string t into an array of characters
        char[] targetChars = t.toCharArray();
        // Store the length of strings s and t
        int sLength = s.length();
        int tLength = t.length();

        // Create two arrays of integers of length tLength + 1
        // dp will store the number of distinct subsequences of s that equal t
        // temp will be used to help update the values in dp
        int[] dp = new int[tLength + 1];
        int[] temp = new int[tLength + 1];

        // Set the first value of dp and temp to 1
        dp[0] = 1;
        temp[0] = 1;

        // Loop through each character in s
        for (int i = 0; i < sLength; i++) {
            // Get the current character of s
            char sChar = s.charAt(i);
            // Loop through each character in t
            for (int j = 1; j < tLength + 1; j++) {
                // If the current character in s matches the current character in t
                if (sChar == targetChars[j - 1]) {
                    // Update the value of dp at index j by adding the value of temp at index j-1
                    dp[j] += temp[j - 1];
                }
                // Update the value of temp at index j-1 with the previous value of dp at index j-1
                temp[j - 1] = dp[j - 1];
            }
        }
        // Return the final value of dp at index tLength
        return dp[tLength];
    }
}
