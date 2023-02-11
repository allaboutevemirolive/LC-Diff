class C12 {
    public static String intToRoman(int num){
        // Check if the input number is within the allowed range
        if (num < 1 || num > 3999) return "";
        
        // Initialize the result string builder
        StringBuilder result = new StringBuilder();
        
        // Define the array of Roman symbols and their corresponding values
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        
        // Initialize the index for the Roman symbols array
        int romanIndex = 0;
        
        // Repeat until the input number is reduced to zero
        while (num > 0) {
            // Repeat until the current value is greater than the value at the current Roman symbols index
            while (num >= values[romanIndex]) {
                // Reduce the input number by the value at the current Roman symbols index
                num -= values[romanIndex];
                // Append the corresponding Roman symbol to the result
                result.append(romanSymbols[romanIndex]);
            }
            // Move to the next index in the Roman symbols array
            romanIndex++;
        }
        // Return the final result as a string
        return result.toString();
    }
}
