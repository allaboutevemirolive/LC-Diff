class C6 {

    public String convert(String inputString, int numOfRows) {
        if (numOfRows == 1) {
            return inputString;
        }

        StringBuilder outputString = new StringBuilder();
        int step = 2 * (numOfRows - 1);

        // Adding characters from the first row
        for (int firstRowIndex = 0; firstRowIndex < inputString.length(); firstRowIndex += step) {
            outputString.append(inputString.charAt(firstRowIndex));
        }

        // Adding characters from the middle rows
        for (int middleRowIndex = 1; middleRowIndex < numOfRows - 1; middleRowIndex++) {
            int characterIndex = middleRowIndex;
            boolean isFirstStep = true;
            while (characterIndex < inputString.length()) {
                outputString.append(inputString.charAt(characterIndex));
                // Determine step size to get the next character
                int stepSize = isFirstStep ? step - 2 * middleRowIndex : 2 * middleRowIndex;
                characterIndex += stepSize;
                isFirstStep = !isFirstStep;
            }
        }

        // Adding characters from the last row
        for (int lastRowIndex = numOfRows - 1; lastRowIndex < inputString.length(); lastRowIndex += step) {
            outputString.append(inputString.charAt(lastRowIndex));
        }

        return outputString.toString();
    }
}
