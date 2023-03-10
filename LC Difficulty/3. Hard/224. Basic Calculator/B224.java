class B224 {
    private int currentIndex;

    public int calculate(String s) {
        // Initialize the current index to 0 and start evaluating the expression.
        currentIndex = 0;
        return calculateExpression(s);
    }

    private int calculateExpression(String s) {
		// currentSign will determine whether current number is positive or negative integer
		// (currentSign == + ) = 1
		// (currentSign == - ) = -1
		// -1 will determine if currentNumber should be subtract or not by ( -1 * currentNumber)
        int result = 0, currentNumber = 0, currentSign = 1;
        // Iterate through the string until the end or a closing bracket is found.
        while (currentIndex < s.length()) {
            // Get the current character.
            char currentChar = s.charAt(currentIndex++);
            // If the current character is a digit, add it to the current number.
            if (currentChar >= '0' && currentChar <= '9') {
				// Convert string to number and store it in temporary variable
                currentNumber = currentNumber * 10 + currentChar - '0';
            }
            // If the current character is an opening bracket, evaluate the expression inside the bracket recursively.
            else if (currentChar == '(') {
                currentNumber = calculateExpression(s);
            }
            // If the current character is a closing bracket, return the current result plus the current sign times the current number.
            else if (currentChar == ')') {
                return result + (currentSign * currentNumber);
            }
            // If the current character is a plus or minus sign, add the current number to the result and update the current sign and number accordingly.
            else if (currentChar == '+' || currentChar == '-') {
                // +=  cocentenate old result with new result
				// =   overwrite old result
				result += currentSign * currentNumber;
				// Reset temporary variable so it can store new number
                currentNumber = 0;
                currentSign = (currentChar == '-') ? -1 : 1;
            }
        }
        // Add the last number to the result and return it.
        return result + currentSign * currentNumber;
    }
}
