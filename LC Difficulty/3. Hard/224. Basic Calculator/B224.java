class B224 {
    private int indexCurr;

    public int calculate(String s) {
        indexCurr = 0;
        return calculateExpression(s);
    }

    private int calculateExpression(String s) {
        // signCurr will determine whether current number is positive or negative integer
        int result = 0, numberCurr = 0, signCurr = 1;
        while (indexCurr < s.length()) {
            // Get the current character.
            char characterCurr = s.charAt(indexCurr++);
            if (characterCurr >= '0' && characterCurr <= '9') {
                // Convert string to number and 
                // add it to the numberCurr and
                // store it in temporary variable ( 0 )
                numberCurr = numberCurr * 10 + characterCurr - '0';
            } else if (characterCurr == '(') {
                // evaluate the expression inside the bracket recursively.
                numberCurr = calculateExpression(s);
            } else if (characterCurr == ')') {
                // calculate the "completed bracket" by adding numberCurr(positive or negative) to it
                return result + (signCurr * numberCurr);
            } else if (characterCurr == '+' || characterCurr == '-') {
				// Calculate numberCurr with old signCurr
                result += signCurr * numberCurr;
				// Reset variable so it can store next number in (currentChar >= '0' && currentChar <= '9')
                numberCurr = 0;
				// Update new signCurr to calculate the next new numberCurr
                signCurr = (characterCurr == '-') ? -1 : 1;
            }
        }
        return result + signCurr * numberCurr;
    }
}
