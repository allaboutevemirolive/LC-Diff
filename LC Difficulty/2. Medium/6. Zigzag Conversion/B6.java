class B6 {
    public String convert(String inputString, int numRows) {
        // if the number of rows is 1, return the input string as it is
        if (numRows == 1) {
            return inputString;
        }
        // Store the length of the input string
        int stringLength = inputString.length();
        // Calculate the length of each cycle, which is equal to 2 times the number of rows minus 1
        int cycleLength = 2 * (numRows - 1);
        // Initialize an index variable to keep track of the position in the result array
        int index = 0;
        // Initialize the zigzagStep variable to equal the cycle length
        int zigzagStep = cycleLength;
        // Create a char array to store the result
        char[] result = new char[stringLength];

        // loop through each row
        for (int row = 0; row < numRows; row++) {
            // loop through each character in the input string
            for (int j = row; j < stringLength; j += cycleLength) {
                // add the character in the current position to the result array
                result[index++] = inputString.charAt(j);
                // if the current row is not the first or last row, add the character in the
                // zigzag position to the result array
                if (row != 0 && row != numRows - 1 && j + zigzagStep < stringLength) {
                    result[index++] = inputString.charAt(j + zigzagStep);
                }
            }
            // decrease the zigzag step for the next row
            zigzagStep -= 2;
        }

        return new String(result);
    }
}
