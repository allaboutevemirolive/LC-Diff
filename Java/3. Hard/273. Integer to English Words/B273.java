class B273 {
    // Define arrays to hold the English word representations for numbers below 20
    // and for multiples of 10 between 20 and 90.
    private final String[] belowTwenty = {
            "", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    // Method to convert an integer to its English word representation.
    public String numberToWords(int num) {
        // If num is 0, return "Zero".
        return num == 0 ? "Zero" : helper(num);
    }

    // Recursive helper method to convert an integer to its English word
    // representation.
    private String helper(int num) {
        // Create a StringBuilder to hold the English word representation of the number.
        StringBuilder s = new StringBuilder();

        // If num is less than 20, append the English word representation from the
        // belowTwenty array.
        if (num < 20) {
            s.append(belowTwenty[num]);
        }
        // If num is between 20 and 99, append the English word representation of the
        // tens place and ones place separately.
        else if (num < 100) {
            s
                    .append(tens[num / 10])
                    .append(" ")
                    .append(belowTwenty[num % 10]);
        }

        // If num is between 100 and 999, append the English word representation of the
        // hundreds place and call the helper method recursively for the remainder.
        else if (num < 1000) {
            s
                    .append(helper(num / 100))
                    .append(" Hundred ")
                    .append(helper(num % 100));
        }

        // If num is between 1000 and 999,999, append the English word representation of
        // the thousands place and call the helper method recursively for the remainder.
        else if (num < 1000000) {
            s
                    .append(helper(num / 1000))
                    .append(" Thousand ")
                    .append(helper(num % 1000));
        }

        // If num is between 1,000,000 and 999,999,999, append the English word
        // representation of the millions place and call the helper method recursively
        // for the remainder.
        else if (num < 1000000000) {
            s
                    .append(helper(num / 1000000))
                    .append(" Million ")
                    .append(helper(num % 1000000));
        }

        // If num is greater than or equal to 1,000,000,000, append the English word
        // representation of the billions place and call the helper method recursively
        // for the remainder.
        else {
            s
                    .append(helper(num / 1000000000))
                    .append(" Billion ")
                    .append(helper(num % 1000000000));
        }

        // Return the English word representation of the number, trimmed of leading and
        // trailing spaces.
        return s.toString().trim();
    }
}
